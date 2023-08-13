package JavaDesignPatterns;

import java.net.URI;

import JavaDesignPatterns.globalModels.DynamoDb;
import com.amazonaws.services.dynamodbv2.local.main.ServerRunner;
import com.amazonaws.services.dynamodbv2.local.server.DynamoDBProxyServer;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeDefinition;
import software.amazon.awssdk.services.dynamodb.model.BillingMode;
import software.amazon.awssdk.services.dynamodb.model.CreateTableRequest;
import software.amazon.awssdk.services.dynamodb.model.DescribeTableRequest;
import software.amazon.awssdk.services.dynamodb.model.KeySchemaElement;
import software.amazon.awssdk.services.dynamodb.model.KeyType;
import software.amazon.awssdk.services.dynamodb.model.ScalarAttributeType;
import software.amazon.awssdk.services.dynamodb.waiters.DynamoDbWaiter;

/**
 * TestSuite implements suite-level operations. Performing them here keeps the individual test classes cleaner.
 */
public class TestSuite {
    // TODO teardown server
    private DynamoDBProxyServer server;
    // Used to create a basic table
    private DynamoDbClient ddbClient;
    // TODO make publicly available so we don't re-create this client
    private DynamoDbEnhancedClient ddbEnhancedClient;

    /**
     * @see https://github.com/awslabs/amazon-dynamodb-local-samples/blob/7b369352bb443c34c10ca9ed66009fafe2cd124e/DynamoDBLocal/src/main/java/aws/example/Main.java#L155-L171
     */
    @BeforeSuite
    public void setUpDynamoDbLocal() throws Exception {
        // We copied the SQL Lite DLLs to the project's build/libs directory during the Gradle build.
        String sqlLitePath = String.format("%s/%s", System.getProperty("user.dir"), "build/libs");
        System.setProperty("sqlite4java.library.path", sqlLitePath);
        final String port = "8000";
        final String[] localArgs = {"-inMemory", "-port", port};

        // Start the local DynamoDb server
        System.out.println("Starting DynamoDB Local...");
        this.server = ServerRunner.createServerFromCommandLineArgs(localArgs);
        this.server.start();

        createDynamoDbClient(port);

        CreateTableRequest createTableRequest = CreateTableRequest.builder()
            .attributeDefinitions(
                AttributeDefinition.builder()
                    .attributeName(DynamoDb.PARTITION_KEY_NAME)
                    .attributeType(ScalarAttributeType.S)
                    .build()
            )
            .keySchema(KeySchemaElement.builder()
                .attributeName(DynamoDb.PARTITION_KEY_NAME)
                .keyType(KeyType.HASH)
                .build())
            .tableName(DynamoDb.TABLE_NAME)
            .billingMode(BillingMode.PAY_PER_REQUEST)
            .build();

        // Send a request to create the table
        this.ddbClient.createTable(createTableRequest);

        // Wait until the table is created, then print the details.
        DynamoDbWaiter waiter = this.ddbClient.waiter();
        waiter.waitUntilTableExists(describeTableRequest())
            .matched()
            .response()
            .ifPresent(System.out::println);
    }

    @AfterSuite
    public void destroyDynamoDb() throws Exception {
        this.ddbClient.close();
        this.server.stop();
    }

    private void createDynamoDbClient(String port) {
        final String ddbUri = "http://localhost:" + port;
        this.ddbClient = DynamoDbClient.builder()
            .endpointOverride(URI.create(ddbUri))
            .httpClient(UrlConnectionHttpClient.builder().build())
            .region(Region.US_WEST_2)
            .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(
                "dummyKey",
                "dummySecret"
            )))
            .build();

        this.ddbEnhancedClient = DynamoDbEnhancedClient.builder()
            .dynamoDbClient(this.ddbClient)
            .build();
    }

    private DescribeTableRequest describeTableRequest() {
        return DescribeTableRequest.builder()
            .tableName(DynamoDb.TABLE_NAME)
            .build();
    }
}

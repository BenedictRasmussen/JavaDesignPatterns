package JavaDesignPatterns.prototype;

import JavaDesignPatterns.globalModels.DynamoDb;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.net.URI;
import java.util.concurrent.atomic.AtomicInteger;

public class DynamoDbProxy {
    private static final DynamoDbProxy instance = new DynamoDbProxy();

    private static AtomicInteger getItemHits = new AtomicInteger(0);
    public static DynamoDbProxy getInstance() {
        return DynamoDbProxy.instance;
    }

    private final DynamoDbEnhancedClient ddbEnhancedClient;

    private DynamoDbProxy() {
        final String ddbUri = "http://localhost:8000";
        final DynamoDbClient ddbClient = DynamoDbClient.builder()
            .endpointOverride(URI.create(ddbUri))
            .httpClient(UrlConnectionHttpClient.builder().build())
            .region(Region.US_WEST_2)
            .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(
                "dummyKey",
                "dummySecret"
            )))
            .build();

        this.ddbEnhancedClient = DynamoDbEnhancedClient.builder()
            .dynamoDbClient(ddbClient)
            .build();
    }

    /**
     * For testing.
     *
     * @return the number of times the getItem method has been called.
     */
    public static int getItemHits() {
        return DynamoDbProxy.getItemHits.get();
    }

    /**
     *
     * @param <T> the generic type representing the bean we are going to return
     * @param beanClass the class of the bean we are retrieving
     * @param key the {@link Key} we are using to retrieve the item
     * @return the instance of the item associated with the key from the database, or null if it does not exist.
     */
    public <T> T getItem(Class<T> beanClass, Key key) {
        DynamoDbProxy.getItemHits.incrementAndGet();
        final DynamoDbTable<T> table = ddbEnhancedClient.table(DynamoDb.TABLE_NAME, TableSchema.fromBean(beanClass));
        return table.getItem(key);
    }

}

package JavaDesignPatterns.prototype;

import JavaDesignPatterns.TestSuite;
import JavaDesignPatterns.globalModels.DynamoDb;
import JavaDesignPatterns.prototype.models.ProductDescription;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

public class PrototypeTest {
    private DynamoDbTable<ProductDescription> productTable;

    @BeforeClass
    private void setupDynamoDb() {
        DynamoDbEnhancedClient ddbClient = TestSuite.getDynamoDbEnhancedClient();
        this.productTable = ddbClient.table(DynamoDb.TABLE_NAME, TableSchema.fromBean(ProductDescription.class));

        ProductDescription doorDetails = new ProductDescription();
        doorDetails.setProductId("Wooden");
        doorDetails.setProductType("Door");
        doorDetails.setDescription("A plain wooden door");
        doorDetails.setRating(4);

        productTable.putItem(doorDetails);
    }

    @Test
    public void test() {
        ProductDescription actual = this.productTable.getItem(Key.builder()
            .partitionValue("Wooden")
            .sortValue("Door")
            .build());

        System.out.println(String.format("%s - %s - %s - %s", actual.getProductId(), actual.getProductType(), actual.getDescription(), actual.getRating()));
        Assertions.assertThat(actual.getProductId()).isEqualTo("Wooden");
    }
}

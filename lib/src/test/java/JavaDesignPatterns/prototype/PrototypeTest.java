package JavaDesignPatterns.prototype;

import JavaDesignPatterns.TestSuite;
import JavaDesignPatterns.globalModels.DynamoDb;
import JavaDesignPatterns.prototype.models.ProductDetailsBean;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

public class PrototypeTest {
    private final ProductDetails productDetails = ProductDetails.getInstance();
    private DynamoDbTable<ProductDetailsBean> productTable;

    @BeforeClass
    private void setupDynamoDb() {
        DynamoDbEnhancedClient ddbClient = TestSuite.getDynamoDbEnhancedClient();
        this.productTable = ddbClient.table(DynamoDb.TABLE_NAME, TableSchema.fromBean(ProductDetailsBean.class));

        ProductDetailsBean doorDetails = new ProductDetailsBean();
        doorDetails.setProductId("Wooden");
        doorDetails.setProductType("Door");
        doorDetails.setDescription("A plain wooden door");
        doorDetails.setRating(4);

        productTable.putItem(doorDetails);
    }

    @Test
    public void testDynamoDbClient() {
        ProductDetailsBean actual = this.productTable.getItem(Key.builder()
            .partitionValue("Wooden")
            .sortValue("Door")
            .build());

        System.out.println(String.format("%s - %s - %s - %s", actual.getProductId(), actual.getProductType(), actual.getDescription(), actual.getRating()));
        Assertions.assertThat(actual.getProductId()).isEqualTo("Wooden");
    }

    @Test
    public void testPrototype() {
        ProductDetailsBean actual = productDetails.retrieve("Wooden", "Door");

        Assertions.assertThat(actual.getProductId()).isEqualTo("Wooden");
        Assertions.assertThat(actual.getProductType()).isEqualTo("Door");
        Assertions.assertThat(actual.getDescription()).isEqualTo("A plain wooden door");
        Assertions.assertThat(actual.getRating()).isEqualTo(4);

        int cacheMisses = DynamoDbProxy.getItemHits();
        // The first time we call ProductDetails, there are no values in the cache
        Assertions.assertThat(cacheMisses).isEqualTo(1);

        productDetails.retrieve("Wooden", "Door");

        cacheMisses = DynamoDbProxy.getItemHits();
        // The second time we call ProductDetails, the item should have been cached, so cacheMisses should still be 1
        Assertions.assertThat(cacheMisses).isEqualTo(1);
    }
}

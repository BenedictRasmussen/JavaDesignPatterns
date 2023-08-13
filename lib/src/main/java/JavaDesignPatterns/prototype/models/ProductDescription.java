package JavaDesignPatterns.prototype.models;

import JavaDesignPatterns.globalModels.DynamoDb;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
public class ProductDescription {
    private String productId;
    private String description;
    private Integer rating;

    @DynamoDbPartitionKey
    @DynamoDbAttribute(value = DynamoDb.PARTITION_KEY_NAME)
    public String productId() {
        return productId;
    }

    @DynamoDbPartitionKey
    @DynamoDbAttribute(value = DynamoDb.PARTITION_KEY_NAME)
    public void setProductId(String productId) {
        this.productId = productId;
    }

    @DynamoDbAttribute(value = "description")

    public String description() {
        return description;
    }

    @DynamoDbAttribute(value = "description")
    public void setDescription(String description) {
        this.description = description;
    }

    @DynamoDbAttribute(value = "rating")
    public Integer rating() {
        return rating;
    }

    @DynamoDbAttribute(value = "rating")
    public void setRating(Integer rating) {
        this.rating = rating;
    }
}

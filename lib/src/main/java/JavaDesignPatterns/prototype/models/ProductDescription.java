package JavaDesignPatterns.prototype.models;

import JavaDesignPatterns.globalModels.DynamoDb;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@DynamoDbBean
public class ProductDescription {
    private String productId;
    private String productType;
    private String description;
    private Integer rating;

    @DynamoDbPartitionKey
    @DynamoDbAttribute(DynamoDb.PARTITION_KEY_NAME)
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @DynamoDbSortKey
    @DynamoDbAttribute(DynamoDb.SORT_KEY_NAME)
    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @DynamoDbAttribute("description")
    public String getDescription() {
        return description;
    }

    @DynamoDbAttribute("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @DynamoDbAttribute("rating")
    public Integer getRating() {
        return rating;
    }

    @DynamoDbAttribute("rating")
    public void setRating(Integer rating) {
        this.rating = rating;
    }
}

package JavaDesignPatterns.prototype;

import java.util.HashMap;
import java.util.Map;

import JavaDesignPatterns.prototype.models.ProductDetailsBean;
import software.amazon.awssdk.enhanced.dynamodb.Key;

/**
 * ProductDetails is a thread-safe cache that stores details for various product types.
 */
public class ProductDetails {
    private static final ProductDetails instance = new ProductDetails();

    public static ProductDetails getInstance() {
        return ProductDetails.instance;
    }

    private final Map<String, ProductDetailsBean> cache = new HashMap<>();
    private final DynamoDbProxy ddbProxy;

    // TODO create cache object

    private ProductDetails() {
        ddbProxy = DynamoDbProxy.getInstance();
        // TODO load "database", populate cache
    }

    public ProductDetailsBean retrieve(String id, String type) {
        // Create a key for the cache using the product's Id and type, which compose the database's primary key.
        final String cacheKey = id + type;
        return cache.computeIfAbsent(cacheKey, v -> {
            // If the key is not present, compute the value and add it to the map.
            Key key = Key.builder()
                .partitionValue(id)
                .sortValue(type)
                .build();

            // Return from the inner compute function
            return ddbProxy.getItem(ProductDetailsBean.class, key);
        });
    }
}

package JavaDesignPatterns.prototype;

/**
 * ProductDetails is a thread-safe cache that stores details for various product types.
 */
public class ProductDetails {
    private static final ProductDetails instance = new ProductDetails();

    public static ProductDetails getInstance() {
        return ProductDetails.instance;
    }

    // TODO create cache object

    private ProductDetails() {
        // TODO load "database", populate cache
    }
}

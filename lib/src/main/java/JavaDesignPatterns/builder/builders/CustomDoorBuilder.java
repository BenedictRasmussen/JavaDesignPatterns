package JavaDesignPatterns.builder.builders;

/**
 * The {@link CustomDoorBuilder} has no preset defaults, allowing customers to add pieces as they see fit.
 */
public class CustomDoorBuilder implements DoorBuilder {
    private Door door;

    public CustomDoorBuilder() {
        this.door = new Door();
    }

    @Override
    public DoorBuilder addPanel() { return this; }

    @Override
    public DoorBuilder addHinges() {
        return this;
    }

    @Override
    public DoorBuilder addHandle() {
        return this;
    }

    @Override
    public Door build() {
        // TODO Check necessary pieces exist
        return this.door;
    }
}

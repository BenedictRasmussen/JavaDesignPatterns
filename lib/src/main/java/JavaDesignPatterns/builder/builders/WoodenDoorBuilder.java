package JavaDesignPatterns.builder.builders;

import JavaDesignPatterns.builder.models.enums.PaintType;

public class WoodenDoorBuilder implements DoorBuilder {
    private Door door;

    public WoodenDoorBuilder() {
        this.door = new Door();
    }

    @Override
    public DoorBuilder addPaint(PaintType type) {
        return this;
    }

    @Override
    public DoorBuilder addPanel() {
        return this;
    }

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
        return this.door;
    }
}

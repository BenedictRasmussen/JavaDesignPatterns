package JavaDesignPatterns.builder.builders;

import JavaDesignPatterns.builder.models.enums.PaintType;

public interface DoorBuilder {

    /**
     * Adds a coat of paint to the door.
     * @param type the type of paint being added
     * @return this {@link DoorBuilder}, for composition
     */
    public DoorBuilder addPaint(PaintType type);

    /**
     * Adds a {@link Panel} for the door.
     * @return this [DoorBuilder], for composition
     */
    public DoorBuilder addPanel();

    /**
     * Adds a {@link Hinge} to the door.
     * @return this {@link DoorBuilder}, for composition
     */

    public DoorBuilder addHinges();

    /**
     * Adds a {@link Handle} to the door.
     * @return this {@link DoorBuilder}, for composition
     */
    public DoorBuilder addHandle();

    /**
     * Builds and returns a completed {@link Door}.
     * @return this {@link DoorBuilder}, for composition
     */
    public Door build();
}

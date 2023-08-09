package JavaDesignPatterns.builder.builders;

import JavaDesignPatterns.builder.models.DoorBuildException;

public interface DoorBuilder {

    /**
     * Adds a {@link Panel} for the door.
     * @return this [DoorBuilder], for composition
     */
    public DoorBuilder addPanel() throws DoorBuildException;

    /**
     * Adds a {@link Hinge} to the door.
     * @return this {@link DoorBuilder}, for composition
     */

    public DoorBuilder addHinges() throws DoorBuildException;

    /**
     * Adds a {@link Handle} to the door.
     * @return this {@link DoorBuilder}, for composition
     */
    public DoorBuilder addHandle() throws DoorBuildException;

    /**
     * Builds and returns a completed {@link Door}.
     * @return this {@link DoorBuilder}, for composition
     */
    public Door build() throws DoorBuildException;
}

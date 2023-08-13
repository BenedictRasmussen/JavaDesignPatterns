package JavaDesignPatterns.builder.builders;

import JavaDesignPatterns.builder.models.DoorBuildException;

public interface DoorBuilder {

    /**
     * Adds a {@link Panel} for the door.
     *
     * @return this [DoorBuilder], for composition
     */
    DoorBuilder addPanel() throws DoorBuildException;

    /**
     * Adds a {@link Hinge} to the door.
     *
     * @return this {@link DoorBuilder}, for composition
     */

    DoorBuilder addHinges() throws DoorBuildException;

    /**
     * Adds a {@link Handle} to the door.
     *
     * @return this {@link DoorBuilder}, for composition
     */
    DoorBuilder addHandle() throws DoorBuildException;

    /**
     * Builds and returns a completed {@link Door}.
     *
     * @return this {@link DoorBuilder}, for composition
     */
    Door build() throws DoorBuildException;
}

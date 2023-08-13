package JavaDesignPatterns.abstractFactory.models.components.hinge;

import JavaDesignPatterns.abstractFactory.models.Material;
import JavaDesignPatterns.abstractFactory.models.enums.Finish;

/*
 * A hinge is one component of the door.
 */
public interface Hinge {
    /**
     * What material the hinge is made of.
     */
    Material material();

    /**
     * What type of finish is used on the hinge material.
     */
    Finish finish();
}

package JavaDesignPatterns.abstractFactory.models.components.panel;

import JavaDesignPatterns.abstractFactory.models.Material;

public interface Panel {
    /**
     * Whether this door panel type is hollow.
     */
    public boolean isHollow();

    /**
     * What type of material the door panel is made of
     */
    public Material material();
}

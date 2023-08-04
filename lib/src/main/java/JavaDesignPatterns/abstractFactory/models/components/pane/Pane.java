package JavaDesignPatterns.abstractFactory.models.components.pane;

import JavaDesignPatterns.abstractFactory.models.Material;

public interface Pane {
    public boolean isOpaque();

    public boolean canOpen();

    public Material material();
}

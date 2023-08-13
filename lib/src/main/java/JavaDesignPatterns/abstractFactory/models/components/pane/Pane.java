package JavaDesignPatterns.abstractFactory.models.components.pane;

import JavaDesignPatterns.abstractFactory.models.Material;

public interface Pane {
    boolean isOpaque();

    boolean canOpen();

    Material material();
}

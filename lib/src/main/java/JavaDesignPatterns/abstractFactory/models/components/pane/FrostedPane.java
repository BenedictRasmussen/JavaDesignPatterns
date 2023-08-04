package JavaDesignPatterns.abstractFactory.models.components.pane;

import JavaDesignPatterns.abstractFactory.models.Material;

public class FrostedPane implements Pane {

    @Override
    public boolean isOpaque() {
        return true;
    }

    @Override
    public boolean canOpen() {
        return false;
    }

    @Override
    public Material material() {
        return Material.Glass;
    }

}

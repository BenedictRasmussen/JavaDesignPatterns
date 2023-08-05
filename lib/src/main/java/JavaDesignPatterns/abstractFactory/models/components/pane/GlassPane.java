package JavaDesignPatterns.abstractFactory.models.components.pane;

import JavaDesignPatterns.abstractFactory.models.Material;

public class GlassPane implements Pane {

    @Override
    public boolean isOpaque() {
        return false;
    }

    @Override
    public boolean canOpen() {
        return true;
    }

    @Override
    public Material material() {
        return Material.Glass;
    }

}

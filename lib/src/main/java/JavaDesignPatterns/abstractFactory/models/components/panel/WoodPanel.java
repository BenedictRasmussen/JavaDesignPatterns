package JavaDesignPatterns.abstractFactory.models.components.panel;

import JavaDesignPatterns.abstractFactory.models.Material;

public final class WoodPanel implements Panel {

    @Override
    public boolean isHollow() {
        return true;
    }

    @Override
    public Material material() {
        return Material.Wood;
    }

}

package JavaDesignPatterns.abstractFactory.models.components.panel;

import JavaDesignPatterns.abstractFactory.models.Material;

public final class IronPanel implements Panel {

    @Override
    public boolean isHollow() {
        return false;
    }

    @Override
    public Material material() {
        return Material.Iron;
    }
}

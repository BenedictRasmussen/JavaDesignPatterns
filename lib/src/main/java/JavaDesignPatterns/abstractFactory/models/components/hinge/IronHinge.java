package JavaDesignPatterns.abstractFactory.models.components.hinge;

import JavaDesignPatterns.abstractFactory.models.Material;
import JavaDesignPatterns.abstractFactory.models.enums.Finish;

public class IronHinge implements Hinge {

    @Override
    public Material material() {
        return Material.Iron;
    }

    @Override
    public Finish finish() {
        return Finish.Matte;
    }
}

package JavaDesignPatterns.abstractFactory.models.components.hinge;

import JavaDesignPatterns.abstractFactory.models.Material;
import JavaDesignPatterns.abstractFactory.models.enums.Finish;

public class BrassHinge implements Hinge {

    @Override
    public Material material() {
        return Material.Brass;
    }

    @Override
    public Finish finish() {
        return Finish.Shine;
    }
}

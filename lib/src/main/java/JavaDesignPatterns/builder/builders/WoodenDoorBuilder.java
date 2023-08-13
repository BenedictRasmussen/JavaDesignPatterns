package JavaDesignPatterns.builder.builders;

import JavaDesignPatterns.builder.models.enums.Finish;
import JavaDesignPatterns.builder.models.enums.HandleType;
import JavaDesignPatterns.builder.models.enums.Material;

/**
 * The WoodenDoorBuilder creates a wooden door using sensible preset values for the customer.
 */
public class WoodenDoorBuilder implements DoorBuilder {
    private final Door door;

    public WoodenDoorBuilder() {
        this.door = new Door();
    }

    @Override
    public DoorBuilder addPanel() {
        Panel panel = new Panel();
        panel.setMaterial(Material.Wood)
            .setColor("Brown")
            .setPrimer(null)
            .setFinish(Finish.EggShell);
        this.door.setPanel(panel);
        return this;
    }

    @Override
    public DoorBuilder addHinges() {
        Hinge hinge = new Hinge();
        hinge.setMaterial(Material.Brass)
            .setFinish(Finish.Shine);
        this.door.setHinge(hinge);
        return this;
    }

    @Override
    public DoorBuilder addHandle() {
        Handle handle = new Handle();
        handle.setFinish(Finish.Shine)
            .setMaterial(Material.Brass)
            .setType(HandleType.Knob);
        this.door.setHandle(handle);
        return this;
    }

    @Override
    public Door build() {
        return this.door;
    }
}

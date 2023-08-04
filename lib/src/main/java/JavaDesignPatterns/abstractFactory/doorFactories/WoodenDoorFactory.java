package JavaDesignPatterns.abstractFactory.doorFactories;

import JavaDesignPatterns.abstractFactory.models.Door;
import JavaDesignPatterns.abstractFactory.models.components.hinge.BrassHinge;
import JavaDesignPatterns.abstractFactory.models.components.panel.WoodPanel;

/**
 * Creates a wooden door.
 */
public final class WoodenDoorFactory extends DoorFactory {
    private static WoodenDoorFactory instance;

    public static WoodenDoorFactory getInstance() {
        if (WoodenDoorFactory.instance == null) {
            WoodenDoorFactory.instance = new WoodenDoorFactory();
        }

        return WoodenDoorFactory.instance;
    }

    private WoodenDoorFactory() {}

    Door createDoor() {
        return new Door(new BrassHinge(), new WoodPanel());
    }
}

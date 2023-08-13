package JavaDesignPatterns.abstractFactory.doorFactories;

import JavaDesignPatterns.abstractFactory.models.Door;
import JavaDesignPatterns.abstractFactory.models.components.hinge.BrassHinge;
import JavaDesignPatterns.abstractFactory.models.components.panel.WoodPanel;

/**
 * Creates a wooden door.
 */
public class WoodenDoorFactory {
    private static WoodenDoorFactory instance;

    private WoodenDoorFactory() {}

    public static WoodenDoorFactory getInstance() {
        if (WoodenDoorFactory.instance == null) {
            WoodenDoorFactory.instance = new WoodenDoorFactory();
        }

        return WoodenDoorFactory.instance;
    }

    Door createDoor() {
        return new Door(new BrassHinge(), new WoodPanel());
    }
}

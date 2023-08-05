package JavaDesignPatterns.abstractFactory.doorFactories;

import JavaDesignPatterns.abstractFactory.models.Door;
import JavaDesignPatterns.abstractFactory.models.components.hinge.IronHinge;
import JavaDesignPatterns.abstractFactory.models.components.panel.IronPanel;

/**
 * Creates a wooden door.
 */
public class IronDoorFactory {
    private static IronDoorFactory instance;

    public static IronDoorFactory getInstance() {
        if (IronDoorFactory.instance == null) {
            IronDoorFactory.instance = new IronDoorFactory();
        }

        return IronDoorFactory.instance;
    }

    private IronDoorFactory() {}

    Door createDoor() {
        return new Door(new IronHinge(), new IronPanel());
    }
}

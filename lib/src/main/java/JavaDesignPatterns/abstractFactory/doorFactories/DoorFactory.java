package JavaDesignPatterns.abstractFactory.doorFactories;

import JavaDesignPatterns.abstractFactory.OpeningFactory;
import JavaDesignPatterns.abstractFactory.models.Door;
import JavaDesignPatterns.abstractFactory.models.enums.Type;

public class DoorFactory implements OpeningFactory<Door> {

    public Door create(Type type) throws Exception {
        switch (type) {
            case Wood:
                return WoodenDoorFactory.getInstance().createDoor();
            case Iron:
                return IronDoorFactory.getInstance().createDoor();
            default:
                throw new Exception(String.format("Cannot create door of type %s", type));
        }
    }
}

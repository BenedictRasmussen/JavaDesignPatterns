package JavaDesignPatterns.abstractFactory;

import JavaDesignPatterns.abstractFactory.doorFactories.DoorFactory;
import JavaDesignPatterns.abstractFactory.models.enums.FactoryType;
import JavaDesignPatterns.abstractFactory.windowFactories.WindowFactory;

/**
 * Provides a factory for creating an object to fill an opening.
 */
public class OpeningFactoryProvider {
    public static OpeningFactory<?> getFactory(FactoryType type) throws Exception {
        switch (type) {
            case Door:
                return new DoorFactory();
            case Window:
                return new WindowFactory();
            default:
                throw new Exception(String.format("Cannot provide factory of type %s", type));
        }
    }
}

package JavaDesignPatterns.abstractFactory.windowFactories;

import JavaDesignPatterns.abstractFactory.OpeningFactory;
import JavaDesignPatterns.abstractFactory.models.Window;
import JavaDesignPatterns.abstractFactory.models.enums.Type;

public class WindowFactory implements OpeningFactory<Window> {
    public Window create(Type type) throws Exception {
        switch (type) {
            case Frosted:
                return FrostedWindowFactory.getInstance().createWindow();
            default:
                throw new Exception(String.format("Cannot create window of type %s", type));
        }
    }
}

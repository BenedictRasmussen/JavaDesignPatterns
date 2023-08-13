package JavaDesignPatterns.abstractFactory.windowFactories;

import JavaDesignPatterns.abstractFactory.models.Window;
import JavaDesignPatterns.abstractFactory.models.components.pane.FrostedPane;

public class FrostedWindowFactory {
    private static FrostedWindowFactory instance;

    private FrostedWindowFactory() {}

    public static FrostedWindowFactory getInstance() {
        if (FrostedWindowFactory.instance == null) {
            FrostedWindowFactory.instance = new FrostedWindowFactory();
        }

        return FrostedWindowFactory.instance;
    }

    Window createWindow() {
        return new Window(new FrostedPane());
    }
}

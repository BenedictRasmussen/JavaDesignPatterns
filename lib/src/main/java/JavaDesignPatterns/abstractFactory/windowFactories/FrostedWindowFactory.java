package JavaDesignPatterns.abstractFactory.windowFactories;

import JavaDesignPatterns.abstractFactory.models.Window;
import JavaDesignPatterns.abstractFactory.models.components.pane.FrostedPane;

public class FrostedWindowFactory {
    private static FrostedWindowFactory instance;

    public static FrostedWindowFactory getInstance() {
        if (FrostedWindowFactory.instance == null) {
            FrostedWindowFactory.instance = new FrostedWindowFactory();
        }

        return FrostedWindowFactory.instance;
    }

    private FrostedWindowFactory() {}

    Window createWindow() {
        return new Window(new FrostedPane());
    }
}

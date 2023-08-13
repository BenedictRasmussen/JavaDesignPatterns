package JavaDesignPatterns.abstractFactory.windowFactories;

import JavaDesignPatterns.abstractFactory.models.Window;
import JavaDesignPatterns.abstractFactory.models.components.pane.GlassPane;

public class GlassWindowFactory {
    private static GlassWindowFactory instance;

    private GlassWindowFactory() {}

    public static GlassWindowFactory getInstance() {
        if (GlassWindowFactory.instance == null) {
            GlassWindowFactory.instance = new GlassWindowFactory();
        }

        return GlassWindowFactory.instance;
    }

    Window createWindow() {
        return new Window(new GlassPane());
    }
}

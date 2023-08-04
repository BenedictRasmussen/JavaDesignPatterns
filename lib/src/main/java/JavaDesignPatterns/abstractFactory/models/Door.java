package JavaDesignPatterns.abstractFactory.models;

import JavaDesignPatterns.abstractFactory.models.components.hinge.Hinge;
import JavaDesignPatterns.abstractFactory.models.components.panel.Panel;


public class Door {
    private Hinge hinge;
    private Panel panel;

    public Door(Hinge hinge, Panel panel) {
        this.hinge = hinge;
        this.panel = panel;
    }

    public Hinge getHinge() {
        return this.hinge;
    }

    public Panel getPanel() {
        return this.panel;
    }
}

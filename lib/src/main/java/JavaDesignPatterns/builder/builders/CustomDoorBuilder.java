package JavaDesignPatterns.builder.builders;

import JavaDesignPatterns.builder.models.DoorBuildException;
import JavaDesignPatterns.builder.models.enums.Finish;
import JavaDesignPatterns.builder.models.enums.HandleType;
import JavaDesignPatterns.builder.models.enums.Material;

/**
 * The {@link CustomDoorBuilder} has no preset defaults, allowing customers to add pieces as they see fit.
 */
public class CustomDoorBuilder implements DoorBuilder {
    private final Door door;
    private final Handle handle;
    private final Hinge hinge;
    private final Panel panel;

    public CustomDoorBuilder() {
        this.door = new Door();
        this.handle = new Handle();
        this.hinge = new Hinge();
        this.panel = new Panel();
    }

    @Override
    public DoorBuilder addPanel() throws DoorBuildException {
        if (this.panel.material() == null) {
            throw new DoorBuildException("Client must specify the door panel's material");
        }
        this.door.setPanel(this.panel);
        return this;
    }

    /**
     * Sets the material of the door panel.
     *
     * @param material the {@link Material} to paint the door
     * @return this {@link CustomDoorBuilder}, for composition
     */
    public CustomDoorBuilder setPanelMaterial(Material material) {
        this.panel.setMaterial(material);
        return this;
    }

    /**
     * Sets the color of the door panel.
     *
     * @param color the color to paint the door
     * @return this {@link CustomDoorBuilder}, for composition
     */
    public CustomDoorBuilder setPanelColor(String color) {
        this.panel.setColor(color);
        return this;
    }

    /**
     * Sets the primer used on the door panel.
     *
     * @param primerType the type of primer to use, e.g. "Oil-based"
     * @return this {@link CustomDoorBuilder}, for composition
     */
    public CustomDoorBuilder setPanelPrimer(String primerType) {
        this.panel.setPrimer(primerType);
        return this;
    }

    /**
     * Sets the finish used on the door panel
     *
     * @param finish the {@link Finish} to use.
     * @return this {@link CustomDoorBuilder}, for composition
     */
    public CustomDoorBuilder setPanelFinish(Finish finish) {
        this.panel.setFinish(finish);
        return this;
    }

    @Override
    public DoorBuilder addHinges() throws DoorBuildException {
        if (this.hinge.material() == null) {
            throw new DoorBuildException("Client must specify the door hinge's material");
        }

        this.door.setHinge(this.hinge);
        return this;
    }

    /**
     * Sets the material used to create the door hinges.
     *
     * @param material the {@link Material} to use
     * @return this {@link CustomDoorBuilder}, for composition
     */
    public CustomDoorBuilder setHingeMaterial(Material material) {
        this.hinge.setMaterial(material);
        return this;
    }

    /**
     * Sets the finish used on the door hinges.
     *
     * @param finish the finish to use
     * @return this {@link CustomDoorBuilder}, for composition
     */
    public CustomDoorBuilder setHingeFinish(Finish finish) {
        this.hinge.setFinish(finish);
        return this;
    }

    @Override
    public DoorBuilder addHandle() throws DoorBuildException{
        if (this.handle.material() == null || this.handle.type() == null) {
            throw new DoorBuildException("Client must specify the door handle's material and type");
        }

        this.door.setHandle(this.handle);
        return this;
    }

    /**
     * Sets the material to create the door handle with.
     *
     * @param material the {@link Material} to use.
     * @return this {@link CustomDoorBuilder}, for composition
     */
    public CustomDoorBuilder setHandleMaterial(Material material) {
        this.handle.setMaterial(material);
        return this;
    }


    /**
     * Sets the type of handle to install on the door handle.
     *
     * @param type the {@link HandleType} to install on the door
     * @return this {@link CustomDoorBuilder}, for composition
     */
    public CustomDoorBuilder setHandleType(HandleType type) {
        this.handle.setType(type);
        return this;
    }


    /**
     * Sets the finish to use on the door handle.
     *
     * @param finish the {@link Finish} to use on the door handle.
     * @return this {@link CustomDoorBuilder}, for composition
     */
    public CustomDoorBuilder setHandleFinish(Finish finish) {
        this.handle.setFinish(finish);
        return this;
    }

    @Override
    public Door build() {
        // We've left the validation logic to the individual "add" methods.
        return this.door;
    }
}

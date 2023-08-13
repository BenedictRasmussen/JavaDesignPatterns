package JavaDesignPatterns.builder.builders;

import JavaDesignPatterns.builder.models.enums.Finish;
import JavaDesignPatterns.builder.models.enums.HandleType;
import JavaDesignPatterns.builder.models.enums.Material;

/**
 * What type of handle is installed on the door.
 */
public class Handle {
    private Finish finish;
    private Material material;
    private HandleType type;

    /**
     * @return the {@link Finish} used on the handle
     */
    public Finish finish() {
        return finish;
    }

    /**
     * @param finish the {@link Finish} to use on the handle
     *
     * @return the instance of this class for building
     */
    public Handle setFinish(Finish finish) {
        this.finish = finish;
        return this;
    }

    /**
     * @return the {@link Material} the handle is made of
     */
    public Material material() {
        return material;
    }

    /**
     * @param material the {@link Material} the handle is made of
     *
     * @return the instance of this class for building
     */
    public Handle setMaterial(Material material) {
        this.material = material;
        return this;
    }

    /**
     * @return the {@link HandleType} installed on the door
     */
    public HandleType type() {
        return type;
    }

    /**
     * @param type the {@link HandleType} of handle to install on the door
     *
     * @return the instance of this class for building
     */
    public Handle setType(HandleType type) {
        this.type = type;
        return this;
    }
}

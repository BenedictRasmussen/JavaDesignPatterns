package JavaDesignPatterns.builder.builders;

/**
 * A Door object built of various components. Note: The Door class exists alongside the builders so that its setters may
 * be package protected. This makes it so builders may modify the door during the building process, but the values are
 * immutable after the Door is built.
 */
public class Door {
    private Handle handle;
    private Hinge hinge;
    private Panel panel;

    /**
     * @return the {@link Handle} installed on the door
     */
    public Handle handle() {
        return handle;
    }

    /**
     * @param handle the {@link Handle} to install on the door
     *
     * @return the instance of this class for building
     */
    Door setHandle(Handle handle) {
        this.handle = handle;
        return this;
    }

    /**
     * @return the {@link Hinge} installed on the door
     */
    public Hinge hinge() {
        return hinge;
    }

    /**
     * @param hinge the {@link Hinge} to install on the door
     *
     * @return the instance of this class for building
     */
    public Door setHinge(Hinge hinge) {
        this.hinge = hinge;
        return this;
    }

    /**
     * @return the {@link Panel} installed on the door
     */
    public Panel panel() {
        return panel;
    }

    /**
     * @param panel the {@link Panel} to install on the door
     *
     * @return the instance of this class for building
     */
    public Door setPanel(Panel panel) {
        this.panel = panel;
        return this;
    }
}

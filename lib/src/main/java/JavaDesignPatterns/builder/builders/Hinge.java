package JavaDesignPatterns.builder.builders;

import JavaDesignPatterns.builder.models.enums.Finish;
import JavaDesignPatterns.builder.models.enums.Material;

/** A hinge is one component of the door. */
public class Hinge {
  private Finish finish;
  private Material material;

  /**
   * @return what material the hinge is made of
   */
  public Material material() {
    return material;
  }

  /**
   * @param material what material the hinge is made of
   * @return the instance of this class for building
   */
  public Hinge setMaterial(Material material) {
    this.material = material;
    return this;
  }

  /**
   * @return the {@link Finish} used on the hinge
   */
  public Finish finish() {
    return finish;
  }

  /**
   * @param finish the {@link Finish} to use on the hinge
   * @return the instance of this class for building
   */
  public Hinge setFinish(Finish finish) {
    this.finish = finish;
    return this;
  }
}

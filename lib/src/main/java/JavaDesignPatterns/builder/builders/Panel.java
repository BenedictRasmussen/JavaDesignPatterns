package JavaDesignPatterns.builder.builders;

import JavaDesignPatterns.builder.models.enums.Finish;
import JavaDesignPatterns.builder.models.enums.Material;

/**
 * A Panel is the main component of the door. It is made of a material that is painted with a primer
 * and color before being optionally topped with a finish.
 */
public class Panel {
  private Material material;
  private String color;
  private String primer;
  private Finish finish;

  /**
   * @return what color the door is painted
   */
  public String color() {
    return color;
  }

  /**
   * @param color what color the door is painted
   * @return the instance of this class for building
   */
  Panel setColor(String color) {
    this.color = color;
    return this;
  }

  /**
   * @return what type of finish is used on the door material, if any
   */
  public Finish finish() {
    return finish;
  }

  /**
   * @param finish what type of finish is used on the door material, if any
   * @return the instance of this class for building
   */
  Panel setFinish(Finish finish) {
    this.finish = finish;
    return this;
  }

  /**
   * @return what material the door is made of
   */
  public Material material() {
    return material;
  }

  /**
   * @param material what material the door is made of
   * @return the instance of this class for building
   */
  Panel setMaterial(Material material) {
    this.material = material;
    return this;
  }

  /**
   * @return what type of primer is used on the door
   */
  public String primer() {
    return primer;
  }

  /**
   * @param primer what color of primer is used on the door, if any
   * @return the instance of this class for building
   */
  Panel setPrimer(String primer) {
    this.primer = primer;
    return this;
  }
}

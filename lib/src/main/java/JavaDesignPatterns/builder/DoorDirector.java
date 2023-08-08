package JavaDesignPatterns.builder;

import JavaDesignPatterns.builder.builders.DoorBuilder;
import JavaDesignPatterns.builder.builders.Door;
import JavaDesignPatterns.builder.models.enums.PaintType;

public class DoorDirector {
  public static Door build(DoorBuilder builder) {
    return builder
        .addPanel()
        .addPaint(PaintType.Primer)
        .addPaint(PaintType.Color)
        .addPaint(PaintType.Finish)
        .addHinges()
        .addHandle()
        .build();
  }
}

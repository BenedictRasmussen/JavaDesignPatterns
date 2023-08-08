package JavaDesignPatterns.builder;

import JavaDesignPatterns.builder.builders.Door;
import JavaDesignPatterns.builder.builders.DoorBuilder;

public class DoorDirector {
    public static Door build(DoorBuilder builder) {
        return builder
                .addPanel()
                .addHinges()
                .addHandle()
                .build();
    }
}

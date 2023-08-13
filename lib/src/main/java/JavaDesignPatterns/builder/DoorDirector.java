package JavaDesignPatterns.builder;

import JavaDesignPatterns.builder.builders.Door;
import JavaDesignPatterns.builder.builders.DoorBuilder;
import JavaDesignPatterns.builder.models.DoorBuildException;

public class DoorDirector {
    public static Door build(DoorBuilder builder) throws DoorBuildException {
        return builder
            .addPanel()
            .addHinges()
            .addHandle()
            .build();
    }
}

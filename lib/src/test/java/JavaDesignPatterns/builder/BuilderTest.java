package JavaDesignPatterns.builder;

import JavaDesignPatterns.builder.builders.CustomDoorBuilder;
import JavaDesignPatterns.builder.builders.Door;
import JavaDesignPatterns.builder.builders.DoorBuilder;
import JavaDesignPatterns.builder.builders.WoodenDoorBuilder;
import JavaDesignPatterns.builder.models.enums.Finish;
import JavaDesignPatterns.builder.models.enums.HandleType;
import JavaDesignPatterns.builder.models.enums.Material;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BuilderTest {

    /**
     * GIVEN a wooden door order WHEN the director is called THEN the {@link Door} has a shiny brass
     * knob handle AND it has shiny brass hinges AND it has a brown wooden door with no primer and an
     * egg-shell finish
     */
    @Test
    public void testWoodenDoorBuilder() {
        DoorBuilder builder = new WoodenDoorBuilder();
        Door actual = DoorDirector.build(builder);

        assertEquals(Finish.Shine, actual.handle().finish());
        assertEquals(Material.Brass, actual.handle().material());
        assertEquals(HandleType.Knob, actual.handle().type());

        assertEquals(Finish.Shine, actual.hinge().finish());
        assertEquals(Material.Brass, actual.hinge().material());

        assertEquals(Material.Wood, actual.panel().material());
        assertEquals("Brown", actual.panel().color());
        assertNull(actual.panel().primer()); // Clean wood doesn't need a primer!
        assertEquals(Finish.EggShell, actual.panel().finish());
    }

    /**
     * GIVEN a custom door order WHEN the director is called THEN the {@link Door} has a shiny brass
     * knob handle AND it has shiny brass hinges AND it has a brown wooden door with no primer and an
     * egg-shell finish
     */
    @Test
    public void testCustomDoorBuilder() {
        // TODO set up a custom door here

        DoorBuilder builder = new CustomDoorBuilder();
        Door actual = DoorDirector.build(builder);

        assertEquals(Finish.Shine, actual.handle().finish());
        assertEquals(Material.Brass, actual.handle().material());
        assertEquals(HandleType.Knob, actual.handle().type());

        assertEquals(Finish.Shine, actual.hinge().finish());
        assertEquals(Material.Brass, actual.hinge().material());

        assertEquals(Material.Wood, actual.panel().material());
        assertEquals("Brown", actual.panel().color());
        assertNull(actual.panel().primer()); // Clean wood doesn't need a primer!
        assertEquals(Finish.EggShell, actual.panel().finish());
    }
}

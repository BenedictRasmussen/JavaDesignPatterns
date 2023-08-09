package JavaDesignPatterns.builder;

import JavaDesignPatterns.builder.builders.CustomDoorBuilder;
import JavaDesignPatterns.builder.builders.Door;
import JavaDesignPatterns.builder.builders.DoorBuilder;
import JavaDesignPatterns.builder.builders.WoodenDoorBuilder;
import JavaDesignPatterns.builder.models.DoorBuildException;
import JavaDesignPatterns.builder.models.enums.Finish;
import JavaDesignPatterns.builder.models.enums.HandleType;
import JavaDesignPatterns.builder.models.enums.Material;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BuilderTest {

    /**
     * GIVEN a wooden door order
     * WHEN the director is called
     * THEN the {@link Door} has a shiny brass knob handle
     * AND it has shiny brass hinges
     * AND it has a brown wooden door with no primer and an egg-shell finish
     */
    @Test
    public void testWoodenDoorBuilder() {
        DoorBuilder builder = new WoodenDoorBuilder();
        Door actual;

        try {
            actual = DoorDirector.build(builder);
        } catch (DoorBuildException dex) {
            fail(dex);
            return; // Return here so the compiler understands that "actual" has been initialized.
        }

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
        CustomDoorBuilder builder = new CustomDoorBuilder();
        // Prep the custom panel order
        builder.setPanelMaterial(Material.Glass)
               .setPanelColor(null)
               .setPanelFinish(null)
               .setPanelPrimer(null)
               // Prep the custom hinge order
               .setHingeMaterial(Material.Brass)
               .setHingeFinish(Finish.Shine)
               // Prep the custom handle order
               .setHandleMaterial(Material.Brass)
               .setHandleType(HandleType.Flush)
               .setHandleFinish(Finish.EggShell);

        Door actual;

        try {
            actual = DoorDirector.build(builder);
        } catch (DoorBuildException dex) {
            fail(dex);
            return; // Return here so the compiler understands that "actual" has been initialized.
        }

        assertEquals(Finish.EggShell, actual.handle().finish());
        assertEquals(Material.Brass, actual.handle().material());
        assertEquals(HandleType.Flush, actual.handle().type());

        assertEquals(Finish.Shine, actual.hinge().finish());
        assertEquals(Material.Brass, actual.hinge().material());

        assertEquals(Material.Glass, actual.panel().material());
        assertNull(actual.panel().color());
        assertNull(actual.panel().primer()); // Clean wood doesn't need a primer!
        assertNull(actual.panel().finish());
    }

    @Test
    public void testCustomerDoorBuilderNoPanelMaterial() {
        CustomDoorBuilder builder = new CustomDoorBuilder();
        // Set all the required values except the panel type.
        builder.setHingeMaterial(Material.Iron)
               .setHandleType(HandleType.Flush)
               .setHandleMaterial(Material.Iron);

        DoorBuildException exception = assertThrows(DoorBuildException.class, () -> {
            DoorDirector.build(builder);
        });

        assertEquals("Client must specify the door panel's material", exception.getMessage());
    }
}

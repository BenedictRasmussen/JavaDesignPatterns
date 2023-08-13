package JavaDesignPatterns.builder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.fail;
import JavaDesignPatterns.builder.builders.CustomDoorBuilder;
import JavaDesignPatterns.builder.builders.Door;
import JavaDesignPatterns.builder.builders.DoorBuilder;
import JavaDesignPatterns.builder.builders.Handle;
import JavaDesignPatterns.builder.builders.Hinge;
import JavaDesignPatterns.builder.builders.Panel;
import JavaDesignPatterns.builder.builders.WoodenDoorBuilder;
import JavaDesignPatterns.builder.models.DoorBuildException;
import JavaDesignPatterns.builder.models.enums.Finish;
import JavaDesignPatterns.builder.models.enums.HandleType;
import JavaDesignPatterns.builder.models.enums.Material;
import org.testng.annotations.Test;

public class BuilderTest {

    /**
     * GIVEN a wooden door order WHEN the director is called THEN the {@link Door} has a shiny brass knob handle AND it
     * has shiny brass hinges AND it has a brown wooden door with no primer and an egg-shell finish
     */
    @Test
    public void testWoodenDoorBuilder() {
        DoorBuilder builder = new WoodenDoorBuilder();
        Door actual;

        try {
            actual = DoorDirector.build(builder);
        } catch (DoorBuildException dex) {
            fail(dex.getMessage());
            return; // Return here so the compiler understands that "actual" has been initialized.
        }

        Handle actualHandle = actual.handle();
        Hinge actualHinge = actual.hinge();
        Panel actualPanel = actual.panel();

        assertThat(actualHandle.finish()).isEqualTo(Finish.Shine);
        assertThat(actualHandle.material()).isEqualTo(Material.Brass);
        assertThat(actualHandle.type()).isEqualTo(HandleType.Knob);

        assertThat(actualHinge.finish()).isEqualTo(Finish.Shine);
        assertThat(actualHinge.material()).isEqualTo(Material.Brass);

        assertThat(actualPanel.material()).isEqualTo(Material.Wood);
        assertThat(actualPanel.color()).isEqualTo("Brown");
        assertThat(actualPanel.primer()).isNull(); // Clean wood doesn't need a primer!
        assertThat(actualPanel.finish()).isEqualTo(Finish.EggShell);
    }

    /**
     * GIVEN a custom door order WHEN the director is called THEN the {@link Door} has a shiny brass knob handle AND it
     * has shiny brass hinges AND it has a brown wooden door with no primer and an egg-shell finish
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
            fail(dex.getMessage());
            return; // Return here so the compiler understands that "actual" has been initialized.
        }

        Handle actualHandle = actual.handle();
        Hinge actualHinge = actual.hinge();
        Panel actualPanel = actual.panel();

        assertThat(actualHandle.finish()).isEqualTo(Finish.EggShell);
        assertThat(actualHandle.material()).isEqualTo(Material.Brass);
        assertThat(actualHandle.type()).isEqualTo(HandleType.Flush);

        assertThat(actualHinge.finish()).isEqualTo(Finish.Shine);
        assertThat(actualHinge.material()).isEqualTo(Material.Brass);

        assertThat(actualPanel.material()).isEqualTo(Material.Glass);
        assertThat(actualPanel.color()).isNull();
        assertThat(actualPanel.primer()).isNull();
        assertThat(actualPanel.finish()).isNull();
    }

    @Test
    public void testCustomerDoorBuilderNoPanelMaterial() {
        CustomDoorBuilder builder = new CustomDoorBuilder();
        // Set all the required values except the panel type.
        builder.setHingeMaterial(Material.Iron)
            .setHandleType(HandleType.Flush)
            .setHandleMaterial(Material.Iron);

        assertThatThrownBy(() -> {
            DoorDirector.build(builder);
        })
            .isInstanceOf(DoorBuildException.class)
            .hasMessage("Client must specify the door panel's material");
    }
}

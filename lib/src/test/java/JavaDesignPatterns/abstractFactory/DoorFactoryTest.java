package JavaDesignPatterns.abstractFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import JavaDesignPatterns.abstractFactory.doorFactories.DoorFactory;
import JavaDesignPatterns.abstractFactory.models.Door;
import JavaDesignPatterns.abstractFactory.models.Material;
import JavaDesignPatterns.abstractFactory.models.components.hinge.BrassHinge;
import JavaDesignPatterns.abstractFactory.models.components.hinge.Hinge;
import JavaDesignPatterns.abstractFactory.models.components.hinge.IronHinge;
import JavaDesignPatterns.abstractFactory.models.components.panel.IronPanel;
import JavaDesignPatterns.abstractFactory.models.components.panel.Panel;
import JavaDesignPatterns.abstractFactory.models.components.panel.WoodPanel;
import JavaDesignPatterns.abstractFactory.models.enums.FactoryType;
import JavaDesignPatterns.abstractFactory.models.enums.Finish;
import JavaDesignPatterns.abstractFactory.models.enums.Type;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DoorFactoryTest {
    DoorFactory factory;

    @BeforeClass
    public void createFactory() {
        try {
            factory = (DoorFactory) OpeningFactoryProvider.getFactory(FactoryType.Door);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * GIVEN an order for a wooden door
     * WHEN a door is created
     * THEN the hinge is made of brass
     * AND the hinge is shiny
     * AND the panel is made of wood
     * AND the panel is hollow.
     */
    @Test
    public void testWoodDoor() throws Exception {
        Door actual = factory.create(Type.Wood);
        Hinge actualHinge = actual.getHinge();
        Panel actualPanel = actual.getPanel();

        // Test the hinge
        assertThat(actualHinge).isInstanceOf(BrassHinge.class);
        assertThat(actualHinge.material()).isEqualTo(Material.Brass);
        assertThat(actualHinge.finish()).isEqualTo(Finish.Shine);

        // Test the panel
        assertThat(actualPanel).isInstanceOf(WoodPanel.class);
        assertThat(actualPanel.material()).isEqualTo(Material.Wood);
        assertThat(actualPanel.isHollow()).isTrue();
    }

    /**
     * GIVEN an order for a iron door
     * WHEN a door is created
     * THEN the hinge is made of iron
     * AND the hinge is matte
     * AND the panel is made of iron
     * AND the panel is not hollow.
     */
    @Test
    public void testIronDoor() throws Exception {
        Door actual = factory.create(Type.Iron);
        Hinge actualHinge = actual.getHinge();
        Panel actualPanel = actual.getPanel();

        // Test the hinge
        assertThat(actualHinge).isInstanceOf(IronHinge.class);
        assertThat(actualHinge.material()).isEqualTo(Material.Iron);
        assertThat(actualHinge.finish()).isEqualTo(Finish.Matte);

        // Test the panel
        assertThat(actualPanel).isInstanceOf(IronPanel.class);
        assertThat(actualPanel.material()).isEqualTo(Material.Iron);
        assertThat(actualPanel.isHollow()).isFalse();
    }

    /**
     * GIVEN an order for a door type that does not exist
     *  WHEN the factory is called
     *  THEN throw an [Exception]
     */
    @Test
    public void testDefaultCase() {
        assertThatThrownBy(() -> {
            factory.create(Type.Frosted);
        })
            .isInstanceOf(Exception.class)
            .hasMessage("Cannot create door of type Frosted");
    }
}

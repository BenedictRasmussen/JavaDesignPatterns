package JavaDesignPatterns.abstractFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import JavaDesignPatterns.abstractFactory.doorFactories.DoorFactory;
import JavaDesignPatterns.abstractFactory.models.Door;
import JavaDesignPatterns.abstractFactory.models.Material;
import JavaDesignPatterns.abstractFactory.models.components.hinge.BrassHinge;
import JavaDesignPatterns.abstractFactory.models.components.hinge.IronHinge;
import JavaDesignPatterns.abstractFactory.models.components.panel.IronPanel;
import JavaDesignPatterns.abstractFactory.models.components.panel.WoodPanel;
import JavaDesignPatterns.abstractFactory.models.enums.FactoryType;
import JavaDesignPatterns.abstractFactory.models.enums.Finish;
import JavaDesignPatterns.abstractFactory.models.enums.Type;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DoorFactoryTest {
    DoorFactory factory;

    @BeforeAll
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
        // Test the hinge
        assertTrue(actual.getHinge() instanceof BrassHinge);
        assertEquals(Material.Brass, actual.getHinge().material());
        assertEquals(Finish.Shine, actual.getHinge().finish());
        // Test the panel
        assertTrue(actual.getPanel() instanceof WoodPanel);
        assertEquals(Material.Wood, actual.getPanel().material());
        assertTrue(actual.getPanel().isHollow());
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
        // Test the hinge
        assertTrue(actual.getHinge() instanceof IronHinge);
        assertEquals(Material.Iron, actual.getHinge().material());
        assertEquals(Finish.Matte, actual.getHinge().finish());
        // Test the panel
        assertTrue(actual.getPanel() instanceof IronPanel);
        assertEquals(Material.Iron, actual.getPanel().material());
        assertFalse(actual.getPanel().isHollow());
    }

    /**
     * GIVEN an order for a door type that does not exist
     *  WHEN the factory is called
     *  THEN throw an [Exception]
     */
    @Test
    public void testDefaultCase() {
        Exception exception = assertThrows(Exception.class, () -> {
            factory.create(Type.Frosted);
        });

        assertEquals("Cannot create door of type Frosted", exception.getMessage());
    }
}

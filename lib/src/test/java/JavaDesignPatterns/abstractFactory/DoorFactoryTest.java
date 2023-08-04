package JavaDesignPatterns.abstractFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import JavaDesignPatterns.abstractFactory.doorFactories.DoorFactory;
import JavaDesignPatterns.abstractFactory.models.Door;
import JavaDesignPatterns.abstractFactory.models.Material;
import JavaDesignPatterns.abstractFactory.models.components.hinge.BrassHinge;
import JavaDesignPatterns.abstractFactory.models.components.panel.WoodPanel;
import JavaDesignPatterns.abstractFactory.models.enums.FactoryType;
import JavaDesignPatterns.abstractFactory.models.enums.Finish;
import JavaDesignPatterns.abstractFactory.models.enums.Type;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DoorFactoryTest {
    DoorFactory factory;

    @BeforeAll
    public void createFactory() {
        try {
            factory = (DoorFactory) OpeningFactoryProvider.getFactory(FactoryType.Door);
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
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
}

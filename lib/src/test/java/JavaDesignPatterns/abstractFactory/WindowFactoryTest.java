package JavaDesignPatterns.abstractFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import JavaDesignPatterns.abstractFactory.models.Material;
import JavaDesignPatterns.abstractFactory.models.Window;
import JavaDesignPatterns.abstractFactory.models.components.pane.FrostedPane;
import JavaDesignPatterns.abstractFactory.models.components.pane.GlassPane;
import JavaDesignPatterns.abstractFactory.models.enums.FactoryType;
import JavaDesignPatterns.abstractFactory.models.enums.Type;
import JavaDesignPatterns.abstractFactory.windowFactories.WindowFactory;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WindowFactoryTest {
    WindowFactory factory;

    @BeforeAll
    public void createFactory() {
        try {
            factory = (WindowFactory) OpeningFactoryProvider.getFactory(FactoryType.Window);
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
    }

    /**
     * GIVEN a frosted window order
     *  WHEN a window is created
     *  THEN the window's pane is opaque
     *   AND the window cannot open
     *   AND the window is made of glass
     */
    @Test
    public void testFrostedWindow() throws Exception {
        Window actual = factory.create(Type.Frosted);

        assertTrue(actual.pane() instanceof FrostedPane);
        assertTrue(actual.pane().isOpaque());
        assertFalse(actual.pane().canOpen());
        assertEquals(actual.pane().material(), Material.Glass);
    }

    /**
     * GIVEN a glass window order
     *  WHEN a window is created
     *  THEN the window's pane is not opaque
     *   AND the window can open
     *   AND the window is made of glass
     */
    @Test
    public void testGlassWindow() throws Exception {
        Window actual = factory.create(Type.Glass);

        assertTrue(actual.pane() instanceof GlassPane);
        assertFalse(actual.pane().isOpaque());
        assertTrue(actual.pane().canOpen());
        assertEquals(actual.pane().material(), Material.Glass);
    }

    /**
     * GIVEN an order for a window type that does not exist
     *  WHEN the factory is called
     *  THEN throw an [Exception]
     */
    @Test
    public void testDefaultCase() {
        Exception exception = assertThrows(Exception.class, () -> {
            factory.create(Type.Wood);
        });

        assertEquals("Cannot create window of type Wood", exception.getMessage());
    }
}

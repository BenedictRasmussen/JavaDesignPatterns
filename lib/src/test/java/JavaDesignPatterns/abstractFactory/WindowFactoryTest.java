package JavaDesignPatterns.abstractFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import JavaDesignPatterns.abstractFactory.models.Material;
import JavaDesignPatterns.abstractFactory.models.components.pane.FrostedPane;
import JavaDesignPatterns.abstractFactory.models.components.pane.GlassPane;
import JavaDesignPatterns.abstractFactory.models.components.pane.Pane;
import JavaDesignPatterns.abstractFactory.models.enums.FactoryType;
import JavaDesignPatterns.abstractFactory.models.enums.Type;
import JavaDesignPatterns.abstractFactory.windowFactories.WindowFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WindowFactoryTest {
    WindowFactory factory;

    @BeforeClass
    public void createFactory() {
        try {
            factory = (WindowFactory)OpeningFactoryProvider.getFactory(FactoryType.Window);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * GIVEN a frosted window order WHEN a window is created THEN the window's pane is opaque AND the window cannot open
     * AND the window is made of glass
     */
    @Test
    public void testFrostedWindow() throws Exception {
        Pane actual = factory.create(Type.Frosted).pane();
        assertThat(actual).isInstanceOf(FrostedPane.class);
        assertThat(actual.isOpaque()).isTrue();
        assertThat(actual.canOpen()).isFalse();
        assertThat(actual.material()).isEqualTo(Material.Glass);
    }

    /**
     * 6 GIVEN a glass window order WHEN a window is created THEN the window's pane is not opaque AND the window can
     * open AND the window is made of glass
     */
    @Test
    public void testGlassWindow() throws Exception {
        Pane actual = factory.create(Type.Glass).pane();
        assertThat(actual).isInstanceOf(GlassPane.class);
        assertThat(actual.isOpaque()).isFalse();
        assertThat(actual.canOpen()).isTrue();
        assertThat(actual.material()).isEqualTo(Material.Glass);
    }

    /**
     * GIVEN an order for a window type that does not exist WHEN the factory is called THEN throw an [Exception]
     */
    @Test
    public void testDefaultCase() {
        assertThatThrownBy(() -> {
            factory.create(Type.Wood);
        })
            .isInstanceOf(Exception.class)
            .hasMessage("Cannot create window of type Wood");
    }
}

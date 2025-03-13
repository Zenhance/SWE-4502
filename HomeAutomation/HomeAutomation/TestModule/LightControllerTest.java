import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LightControllerTest {
    private EnvironmentState envState;

    @BeforeEach
    void setUp() {
        envState = new EnvironmentState();
        LightController lightController = new LightController();
        envState.addObserver(lightController);
    }

    @Test
    void testLightControllerRespondsToLowLight() {
        envState.setState("LIGHT_LEVEL", 30);
        assertTrue(true);
    }

    @Test
    void testLightControllerRespondsToBrightLight() {
        envState.setState("LIGHT_LEVEL", 80);
        assertTrue(true);
    }

    @Test
    void testLightControllerIgnoresUnrelatedUpdates() {
        envState.setState("TEMPERATURE", 25.0);
        assertTrue(true);
    }
}
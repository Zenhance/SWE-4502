

import Components.LightController;
import Core.EnvironmentState;
import Core.SmartHomeData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LightControllerTest {
    private EnvironmentState envState;
    private SmartHomeData homeData;
    private LightController lightController;

    @BeforeEach
    void setUp() {
        envState = new EnvironmentState();
        homeData = new SmartHomeData();
        lightController = new LightController(homeData);
        envState.addObserver(lightController);
    }

    @Test
    void testLightControllerRespondsToLowLight() {
        envState.setState("LIGHT_LEVEL", 30);
        assertTrue(lightController.areLightsOn()); // Verifies lights turn ON
    }

    @Test
    void testLightControllerRespondsToBrightLight() {
        envState.setState("LIGHT_LEVEL", 80);
        assertFalse(lightController.areLightsOn()); // Verifies lights turn OFF
    }

    @Test
    void testLightControllerIgnoresUnrelatedUpdates() {
        envState.setState("TEMPERATURE", 24.0);
        assertFalse(lightController.areLightsOn()); // Ensures no impact from unrelated updates
    }
}

package UnitTest;

import CoreFramework.*;
import LightManagement.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LightControllerTest {
    private LightController lightController;
    private EnvironmentMonitor monitor;

    @BeforeEach
    void setUp() {
        lightController = new LightController();
        monitor = new EnvironmentMonitor();
        monitor.registerObserver(lightController);
    }

    @Test
    void testLightsTurnOnWhenDarkAndOccupied() {
        monitor.setState(new EnvironmentState(true, 22, 20)); // Motion detected, low light
        assertTrue(lightController.isLightOn(), "Lights should be ON when dark and occupied.");
    }

    @Test
    void testLightsRemainOffWhenBright() {
        monitor.setState(new EnvironmentState(true, 22, 80)); // Bright environment
        assertFalse(lightController.isLightOn(), "Lights should be OFF when it's bright.");
    }

    @Test
    void testLightsTurnOffWhenRoomEmpty() {
        monitor.setState(new EnvironmentState(false, 22, 10)); // No motion, dark
        assertFalse(lightController.isLightOn(), "Lights should be OFF when the room is empty.");
    }

   

}

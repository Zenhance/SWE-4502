

import Components.TemperatureController;
import Core.EnvironmentState;
import Core.SmartHomeData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TemperatureControllerTest {
    private EnvironmentState envState;
    private SmartHomeData homeData;
    private TemperatureController temperatureController;

    @BeforeEach
    void setUp() {
        envState = new EnvironmentState();
        homeData = new SmartHomeData();
        temperatureController = new TemperatureController(homeData);
        envState.addObserver(temperatureController);
    }

    @Test
    void testTemperatureControllerHeatsWhenTooCold() {
        envState.setState("TEMPERATURE", 18.0);
        assertTrue(temperatureController.isHeatingOn()); // Ensures heater turns on
        assertFalse(temperatureController.isCoolingOn()); // AC should be OFF
    }

    @Test
    void testTemperatureControllerCoolsWhenTooHot() {
        envState.setState("TEMPERATURE", 26.0);
        assertTrue(temperatureController.isCoolingOn()); // Ensures AC turns on
        assertFalse(temperatureController.isHeatingOn()); // Heater should be OFF
    }

    @Test
    void testTemperatureControllerIgnoresUnrelatedUpdates() {
        envState.setState("LIGHT_LEVEL", 40);
        assertFalse(temperatureController.isCoolingOn());
        assertFalse(temperatureController.isHeatingOn()); // Ensures system stays idle
    }

    @Test
    void testTemperatureControllerMaintainsStableTemperature() {
        envState.setState("TEMPERATURE", 22.0);
        assertFalse(temperatureController.isCoolingOn());
        assertFalse(temperatureController.isHeatingOn()); // No need to heat or cool
    }
}

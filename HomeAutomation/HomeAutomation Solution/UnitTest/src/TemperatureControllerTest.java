import CoreFramework.HomeEnvironment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import TemperatureController.*;

class TemperatureControllerTest {
    private TemperatureController temperatureController;
    private HomeEnvironment homeEnvironment;

    @BeforeEach
    void setUp() {
        homeEnvironment = HomeEnvironment.getInstance();
        temperatureController = new TemperatureController();
    }

    @Test
    void testSetCurrentTemperature() {
        temperatureController.setCurrentTemperature(18.0);
        assertEquals(18.0, temperatureController.getCurrentTemperature(), "Current temperature should update correctly");
    }

    @Test
    void testSetTargetTemperature() {
        temperatureController.setTargetTemperature(24.0);
        assertEquals(24.0, temperatureController.getTargetTemperature(), "Target temperature should update correctly");
    }

    @Test
    void testHeatingTurnsOnWhenBelowTarget() {
        temperatureController.setTargetTemperature(22.0);
        temperatureController.setCurrentTemperature(21.0); // 22 - 0.5 > 21, heating should turn on

        assertTrue(temperatureController.isHeatingOn(), "Heating should be ON when temperature is below target minus hysteresis");
        assertFalse(temperatureController.isCoolingOn(), "Cooling should be OFF when heating is ON");
    }

    @Test
    void testCoolingTurnsOnWhenAboveTarget() {
        temperatureController.setTargetTemperature(22.0);
        temperatureController.setCurrentTemperature(23.0); // 22 + 0.5 < 23, cooling should turn on

        assertTrue(temperatureController.isCoolingOn(), "Cooling should be ON when temperature is above target plus hysteresis");
        assertFalse(temperatureController.isHeatingOn(), "Heating should be OFF when cooling is ON");
    }

    @Test
    void testHeatingTurnsOffAtTargetTemperature() {
        temperatureController.setTargetTemperature(22.0);
        temperatureController.setCurrentTemperature(21.0); // Heating should turn on
        temperatureController.setCurrentTemperature(22.0); // Now heating should turn off

        assertFalse(temperatureController.isHeatingOn(), "Heating should be OFF when reaching target temperature");
    }

    @Test
    void testCoolingTurnsOffAtTargetTemperature() {
        temperatureController.setTargetTemperature(22.0);
        temperatureController.setCurrentTemperature(23.0); // Cooling should turn on
        temperatureController.setCurrentTemperature(22.0); // Now cooling should turn off

        assertFalse(temperatureController.isCoolingOn(), "Cooling should be OFF when reaching target temperature");
    }

    @Test
    void testTemperatureUpdateViaObserver() {
        homeEnvironment.setState("temperature", 19.0);
        assertEquals(19.0, temperatureController.getCurrentTemperature(), "Observer should update current temperature");

        homeEnvironment.setState("targetTemperature", 25.0);
        assertEquals(25.0, temperatureController.getTargetTemperature(), "Observer should update target temperature");
    }
}

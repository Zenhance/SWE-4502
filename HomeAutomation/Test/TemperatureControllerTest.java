package Test;

import org.junit.jupiter.api.Test;
import Code.Controllers.TemperatureController;
import Code.StateManagementClasses.StateManager;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureControllerTest {

    //  Test if heating activates when temperature is below target-hysteresis
    @Test
    void testHeatingActivates_LowTemperature() {
        StateManager stateManager = new StateManager();
        TemperatureController tempController = new TemperatureController(stateManager);

        tempController.onStateChange("temperature", 20.0); // Below 22 - 1
        assertTrue(tempController.isHeatingOn(), "Heating should be activated.");
        assertFalse(tempController.isCoolingOn(), "Cooling should be off.");
    }

    // Test if cooling activates when temperature is above target+hysteresis
    @Test
    void testCoolingActivates_HighTemperature() {
        StateManager stateManager = new StateManager();
        TemperatureController tempController = new TemperatureController(stateManager);

        tempController.onStateChange("temperature", 24.5); // Above 22 + 1
        assertTrue(tempController.isCoolingOn(), "Cooling should be activated.");
        assertFalse(tempController.isHeatingOn(), "Heating should be off.");
    }

    // Test if HVAC stays off when temperature is within hysteresis range
    @Test
    void testHVAC_TurnsOff_WithinHysteresis() {
        StateManager stateManager = new StateManager();
        TemperatureController tempController = new TemperatureController(stateManager);

        tempController.onStateChange("temperature", 22.5); // Within 22 ± 1
        assertFalse(tempController.isCoolingOn(), "Cooling should be off.");
        assertFalse(tempController.isHeatingOn(), "Heating should be off.");
    }
}

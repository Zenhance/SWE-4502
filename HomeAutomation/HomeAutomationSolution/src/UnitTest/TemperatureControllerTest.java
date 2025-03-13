package UnitTest;

import CoreFramework.*;
import TemperatureControl.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TemperatureControllerTest {
    private TemperatureController tempController;
    private EnvironmentMonitor monitor;

    @BeforeEach
    void setUp() {
        tempController = new TemperatureController(22); // Target: 22°C
        monitor = new EnvironmentMonitor();
        monitor.registerObserver(tempController);
    }

    @Test
    void testHeatingTurnsOnWhenTooCold() {
        monitor.setState(new EnvironmentState(false, 18, 50)); // 18°C (Below target - 2)
        assertTrue(tempController.isHeatingOn(), "Heating should be ON when temperature is too low.");
        assertFalse(tempController.isCoolingOn(), "Cooling should be OFF.");
    }

    @Test
    void testCoolingTurnsOnWhenTooHot() {
        monitor.setState(new EnvironmentState(false, 25, 50)); // 25°C (Above target + 2)
        assertTrue(tempController.isCoolingOn(), "Cooling should be ON when temperature is too high.");
        assertFalse(tempController.isHeatingOn(), "Heating should be OFF.");
    }

    @Test
    void testHVACOffWhenWithinHysteresisRange() {
        monitor.setState(new EnvironmentState(false, 22, 50)); // 22°C (Within range)
        assertFalse(tempController.isHeatingOn(), "Heating should be OFF when within range.");
        assertFalse(tempController.isCoolingOn(), "Cooling should be OFF when within range.");
    }
}

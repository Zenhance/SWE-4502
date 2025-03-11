package Test;

import org.junit.jupiter.api.Test;
import Code.Controllers.EnergyMonitor;
import Code.StateManagementClasses.StateManager;

import static org.junit.jupiter.api.Assertions.*;

class EnergyMonitorTest {

    //Test if energy is tracked and total usage accumulates
    @Test
    void testEnergyTracking() {
        StateManager stateManager = new StateManager();
        EnergyMonitor energyMonitor = new EnergyMonitor(stateManager);

        energyMonitor.onStateChange("powerUsage", 1000.0);
        energyMonitor.onStateChange("powerUsage", 2000.0);

        assertEquals(3000.0, energyMonitor.getTotalConsumption(), "Total consumption should be 3000.0Wh.");
    }

    //Test if high power usage is correctly detected
    @Test
    void testHighPowerUsageDetection() {
        StateManager stateManager = new StateManager();
        EnergyMonitor energyMonitor = new EnergyMonitor(stateManager);

        assertTrue(energyMonitor.isHighConsumption(5000.0), "5000W should be flagged as high consumption.");
        assertFalse(energyMonitor.isHighConsumption(3000.0), "3000W should NOT be flagged as high consumption.");
    }

    // Test if invalid key does not modify the state
    @Test
    void testInvalidKeyDoesNothing() {
        StateManager stateManager = new StateManager();
        EnergyMonitor energyMonitor = new EnergyMonitor(stateManager);

        energyMonitor.onStateChange("invalidKey", 1000.0);

        assertTrue(energyMonitor.getPowerUsageHistory().isEmpty(), "No power usage should be recorded for an invalid key.");
    }
}

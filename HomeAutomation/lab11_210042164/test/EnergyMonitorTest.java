package lab11_210042164.test;


import lab11_210042164.implementation.features.EnergyMonitor;
import lab11_210042164.implementation.manager.StateManager;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class EnergyMonitorTest {

    private TestStateManager testStateManager;
    private EnergyMonitor energyMonitor;

    private static class TestStateManager extends StateManager {
        private Map<String, Object> updatedStates = new HashMap<>();

        @Override
        public void updateState(String key, Object value) {
            super.updateState(key, value);
            updatedStates.put(key, value);
        }

        public boolean wasStateUpdated(String key) {
            return updatedStates.containsKey(key);
        }

        public Object getUpdatedValue(String key) {
            return updatedStates.get(key);
        }

        public void clearUpdatedStates() {
            updatedStates.clear();
        }
    }

    @Before
    public void setUp() {
        testStateManager = new TestStateManager();
        energyMonitor = new EnergyMonitor(testStateManager);
    }

    @Test
    public void testInitialState() {
        assertEquals(0.0, energyMonitor.getTotalConsumption(), 0.01);
        assertEquals(0, energyMonitor.getPowerUsageHistory().size());
        assertEquals(4000.0, energyMonitor.getThreshold(), 0.01);
    }

    @Test
    public void testTrackEnergyConsumption() {
        // Track several power usage values
        energyMonitor.onStateChange("powerUsage", 1000.0);
        energyMonitor.onStateChange("powerUsage", 1500.0);
        energyMonitor.onStateChange("powerUsage", 2000.0);

        // Verify history was recorded
        List<Double> history = energyMonitor.getPowerUsageHistory();
        assertEquals(3, history.size());
        assertEquals(1000.0, history.get(0), 0.01);
        assertEquals(1500.0, history.get(1), 0.01);
        assertEquals(2000.0, history.get(2), 0.01);

        // Verify total consumption
        assertEquals(4500.0, energyMonitor.getTotalConsumption(), 0.01);
    }

    @Test
    public void testHighConsumptionAlert() {
        testStateManager.clearUpdatedStates();

        // Track normal power usage
        energyMonitor.onStateChange("powerUsage", 2000.0);
        assertTrue(testStateManager.wasStateUpdated("highPowerUsageAlert"));
        assertFalse((Boolean)testStateManager.getUpdatedValue("highPowerUsageAlert"));

        // Track high power usage (above threshold)
        energyMonitor.onStateChange("powerUsage", 4500.0);

        // Verify high usage alert was triggered
        assertTrue(energyMonitor.isHighConsumption(4500.0));
        assertTrue(testStateManager.wasStateUpdated("highPowerUsageAlert"));
        assertTrue((Boolean)testStateManager.getUpdatedValue("highPowerUsageAlert"));
    }

    @Test
    public void testAveragePowerUsage() {
        // Track several power usage values
        energyMonitor.onStateChange("powerUsage", 1000.0);
        energyMonitor.onStateChange("powerUsage", 2000.0);
        energyMonitor.onStateChange("powerUsage", 3000.0);

        // Verify average calculation
        assertEquals(2000.0, energyMonitor.getAveragePowerUsage(), 0.01);
    }

    @Test
    public void testMaxPowerUsage() {
        // Track several power usage values
        energyMonitor.onStateChange("powerUsage", 1000.0);
        energyMonitor.onStateChange("powerUsage", 3000.0);
        energyMonitor.onStateChange("powerUsage", 2000.0);

        // Verify max calculation
        assertEquals(3000.0, energyMonitor.getMaxPowerUsage(), 0.01);
    }

    @Test
    public void testThresholdChange() {
        // Change threshold
        energyMonitor.setThreshold(2500.0);
        assertEquals(2500.0, energyMonitor.getThreshold(), 0.01);

        // Verify threshold is used for detection
        assertTrue(energyMonitor.isHighConsumption(3000.0));
        assertFalse(energyMonitor.isHighConsumption(2000.0));
    }
}

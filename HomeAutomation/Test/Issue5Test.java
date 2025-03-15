import Issue1.StateManager;
import Issue5.DevicePower;
import Issue5.EnergyMonitor;
import Issue5.EnergyStats;
import Issue5.UnusualUsage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Issue5Test {

    private StateManager stateManager;
    private EnergyMonitor monitor;

    @Before
    public void setUp() {
        stateManager = new StateManager();
        monitor = new EnergyMonitor(stateManager);
    }

    @Test
    public void testPowerUsageUpdate() {
        stateManager.updateState("power_usage", 100.0);
        assertEquals(100.0, monitor.getCurrentPowerUsage(), 0.001);
    }

    @Test
    public void testDevicePowerUpdate() {
        stateManager.updateState("device_power", new DevicePower("Device1", 50.0));
        stateManager.updateState("device_power", new DevicePower("Device2", 30.0));
        assertEquals(80.0, monitor.getCurrentPowerUsage(), 0.001);
    }

    @Test
    public void testAnomalyDetection() {
        for (int i = 0; i < 9; i++) {
            stateManager.updateState("power_usage", 50.0);
        }
        stateManager.updateState("power_usage", 200.0);
        UnusualUsage unusualUsage = (UnusualUsage) stateManager.getState("energy_anomaly");
        assertNotNull(unusualUsage);
        assertEquals("Unusual energy consumption", unusualUsage.getMessage());
    }

    @Test
    public void testEnergyStatisticsCalculation() {
        for (int i = 0; i < 10; i++) {
            stateManager.updateState("power_usage", 50.0);
        }
        EnergyStats stats = (EnergyStats) stateManager.getState("energy_statistics");
        assertNotNull(stats);
        assertEquals(50.0, stats.getAveragePower(), 0.001);
        assertEquals(50.0, stats.getPeakPower(), 0.001);
        assertEquals(0.1388, stats.getCumulativeEnergy(), 0.001);
    }
}

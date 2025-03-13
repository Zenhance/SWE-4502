package UnitTest;

import CoreFramework.*;
import EnergyConsumptionTracking.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnergyMonitorTest {
    private EnergyMonitor energyMonitor;
    private EnvironmentMonitor monitor;

    @BeforeEach
    void setUp() {
        energyMonitor = new EnergyMonitor();
        monitor = new EnvironmentMonitor();
        monitor.registerObserver(energyMonitor);
    }

    @Test
    void testEnergyTracking() {
        // power usage = light level *100;
        monitor.setState(new EnvironmentState(false, 22, 10)); // 1000W usage
        monitor.setState(new EnvironmentState(false, 22, 20)); // 2000W usage
        assertEquals(3000, energyMonitor.getTotalUsage(), "Total energy usage should be 3000W.");
    }

    @Test
    void testHighUsageDetection() {
        monitor.setState(new EnvironmentState(false, 22, 60)); // 6000W (Above threshold)
        assertTrue(energyMonitor.isHighUsageDetected(), "High power consumption should be detected.");
    }

    @Test
    void testNormalUsageDoesNotTriggerWarning() {
        monitor.setState(new EnvironmentState(false, 22, 30)); // 3000W (Below threshold)
        assertFalse(energyMonitor.isHighUsageDetected(), "Normal usage should not trigger a warning.");
    }
}

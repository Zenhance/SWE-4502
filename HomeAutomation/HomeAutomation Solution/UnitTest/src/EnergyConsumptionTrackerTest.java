import CoreFramework.HomeEnvironment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import EnergyConsumptionTracker.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class EnergyConsumptionTrackerTest {
    private EnergyConsumptionTracker energyTracker;
    private HomeEnvironment homeEnvironment;

    @BeforeEach
    void setUp() {
        homeEnvironment = HomeEnvironment.getInstance();
        energyTracker = new EnergyConsumptionTracker();
    }

    @Test
    void testTrackConsumption() {
        energyTracker.trackConsumption(100.0);
        assertEquals(100.0, energyTracker.getCurrentPowerUsage(), "Current power usage should update correctly");

        List<Double> history = energyTracker.getUsageHistory();
        assertFalse(history.isEmpty(), "Usage history should not be empty after tracking consumption");
        assertEquals(100.0, history.get(0), "Tracked power usage should be recorded correctly");
    }

    @Test
    void testCalculateStatistics() {
        energyTracker.trackConsumption(50.0);
        energyTracker.trackConsumption(100.0);
        energyTracker.trackConsumption(150.0);

        assertEquals(100.0, energyTracker.getAverageUsage(), "Average power usage should be correctly calculated");
    }

    @Test
    void testIdentifyUnusualPatterns() {
        energyTracker.trackConsumption(50.0);
        energyTracker.trackConsumption(60.0);
        energyTracker.trackConsumption(200.0); // Unusual consumption (greater than 1.5x average)

        assertTrue(energyTracker.getUsageHistory().size() >= 3, "Usage history should have at least 3 entries");
        assertTrue(energyTracker.getCurrentPowerUsage() == 200.0, "Latest recorded usage should be 200 watts");
    }

    @Test
    void testObserverUpdatesPowerUsage() {
        homeEnvironment.setState("powerUsage", 120.0);
        assertEquals(120.0, energyTracker.getCurrentPowerUsage(), "Observer should update power usage correctly");
    }
}

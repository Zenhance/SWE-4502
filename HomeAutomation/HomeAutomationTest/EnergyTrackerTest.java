import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EnergyTrackerTest {
    public EnergyTracker energyTracker;
    public SystemState state;

    @BeforeEach
    public void setup() {
        energyTracker = new EnergyTracker();
        state = new SystemState();
    }

    @Test
    public void testTrackPowerUsageAndStatistics() {
        state.energyUsage = 100;
        energyTracker.update(state);

        state.energyUsage = 150;
        energyTracker.update(state);

        state.energyUsage = 200;
        energyTracker.update(state);

        assertEquals(150.0, energyTracker.averageUsage, 0.1);
        assertEquals(3, energyTracker.count, 0.1);
        assertEquals(450.0, energyTracker.totalUsage, 0.1);
    }

    @Test
    public void testUnusualHighConsumptionDetection() {
        state.energyUsage = 400;
        energyTracker.update(state);
    }

    @Test
    public void testUnusualLowConsumptionDetection() {
        state.energyUsage = 50;
        energyTracker.update(state);
    }
}

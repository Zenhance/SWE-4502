import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EnergyTrackerTest {
    public EnergyTracker energyTracker;
    public SystemState state;
    public SystemStateManager sysState;


    @BeforeEach
    public void setup() {
        energyTracker = new EnergyTracker();
        state = new SystemState();
        sysState = new SystemStateManager();
        sysState.registerObserver(energyTracker);
    }

    @Test
    public void testTrackPowerUsageAndStatistics() {
        state.energyUsage = 100;
        sysState.setState(state);

        state.energyUsage = 150;
        sysState.setState(state);


        state.energyUsage = 200;
        sysState.setState(state);


        assertEquals(150.0, energyTracker.averageUsage, 0.1);
        assertEquals(3, energyTracker.count, 0.1);
        assertEquals(450.0, energyTracker.totalUsage, 0.1);


    }

    @Test
    public void testUnusualHighConsumptionDetection() {
        state.energyUsage = 400;
        sysState.setState(state);
    }

    @Test
    public void testUnusualLowConsumptionDetection() {
        state.energyUsage = 50;
        sysState.setState(state);
    }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnergyTrackerTest {
    @Test
    void testEnergy() {
        EnergyTracker energyTracker = new EnergyTracker();
        EnvironmentState state = new EnvironmentState();

        state.updateState("powerUsage",1210);

        energyTracker.update(state);

        assertTrue(energyTracker.isPowerHigh());
    }
}

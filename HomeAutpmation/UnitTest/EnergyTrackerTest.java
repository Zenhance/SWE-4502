import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EnergyTrackerTest {

    private SystemStateManager manager;
    private EnergyTracker energyTracker;

    @BeforeEach
    public void setUp() {
        manager = new SystemStateManager();
        energyTracker = new EnergyTracker();
        manager.addObserver(energyTracker);
    }
    @Test
    public void testEnergyConsumptionDetection() {
        SystemState energyState = new SystemState(SystemStateType.POWER_CONSUMPTION_DETECTED, "Power Consumption Detected");
        manager.setState(energyState);

    }


}

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    @Test
    public void testLogAndTrackEnergyConsumption() {
          int consumption1 = 100;
        int consumption2 = 150;
        int consumption3 = 200;

        energyTracker.logEnergyConsumption(consumption1);
        energyTracker.trackUsageStats(consumption1);

        energyTracker.logEnergyConsumption(consumption2);
        energyTracker.trackUsageStats(consumption2);

        energyTracker.logEnergyConsumption(consumption3);
        energyTracker.trackUsageStats(consumption3);


        assertEquals(450, energyTracker.getTotalConsumption());
    }


    @Test
    public void testResetEnergyConsumption() {
        energyTracker.logEnergyConsumption(100);
        energyTracker.trackUsageStats(100);

        energyTracker.logEnergyConsumption(200);
        energyTracker.trackUsageStats(200);

        assertEquals(300, energyTracker.getTotalConsumption());


        energyTracker.resetConsumption();


        assertEquals(0, energyTracker.getTotalConsumption());
    }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnergyTrackerTest {

    @Test
    void testEnergyConsumptionTracking() {
        EnergyTracker tracker = new EnergyTracker();


        EnvironmentalState normalState = new EnvironmentalState();
        normalState.powerUsage=200;
        tracker.update(normalState);
        assertEquals(200, tracker.getPowerUsage(), "Power usage should be 200");

        EnvironmentalState highUsageState = new EnvironmentalState();
        highUsageState.powerUsage=600;
        tracker.update(highUsageState);
        assertEquals(600, tracker.getPowerUsage(), "Power usage should be 600");
    }
}

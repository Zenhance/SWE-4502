package EnergyConsumption;

import Core.HomeEnvironment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EnergyTest {

    private Energy energy;
    private HomeEnvironment homeEnvironment;

    @BeforeEach
    void setUp() {
        energy = new Energy();
        homeEnvironment = HomeEnvironment.getInstance();
        homeEnvironment.registerObserver("powerUsage", energy); // Register observer for power usage updates
    }

    @Test
    void testLogPowerUsage() {
        // Simulate power usage
        homeEnvironment.setState("powerUsage", 350.0);
        homeEnvironment.setState("powerUsage", 450.0);

        // Verify that power usage data contains the correct values
        List<Double> powerUsageData = energy.getPowerUsageData();
        assertEquals(2, powerUsageData.size(), "There should be two power usage entries.");
        assertEquals(350.0, powerUsageData.get(0), "The first power usage should be 350.0.");
        assertEquals(450.0, powerUsageData.get(1), "The second power usage should be 450.0.");
    }

    @Test
    void testTotalPowerUsage() {
        // Log power usage
        homeEnvironment.setState("powerUsage", 350.0);
        homeEnvironment.setState("powerUsage", 450.0);

        // Verify the total power usage
        assertEquals(800.0, energy.getTotalPowerUsage(), "Total power usage should be 800.0.");
    }

    @Test
    void testAveragePowerUsage() {
        // Log power usage
        homeEnvironment.setState("powerUsage", 350.0);
        homeEnvironment.setState("powerUsage", 450.0);

        // Verify the average power usage
        assertEquals(400.0, energy.getAveragePowerUsage(), 0.01, "Average power usage should be 400.0.");
    }

    @Test
    void testMaxPowerUsage() {
        // Log power usage
        homeEnvironment.setState("powerUsage", 350.0);
        homeEnvironment.setState("powerUsage", 450.0);
        homeEnvironment.setState("powerUsage", 500.0);

        // Verify the maximum power usage
        assertEquals(500.0, energy.getMaxPowerUsage(), "Maximum power usage should be 500.0.");
    }

    @Test
    void testUnusualConsumptionPattern() {
        // Simulate normal power usage (below the threshold)
        homeEnvironment.setState("powerUsage", 350.0);
        homeEnvironment.setState("powerUsage", 450.0);
        homeEnvironment.setState("powerUsage", 300.0);
        homeEnvironment.setState("powerUsage", 400.0);
        homeEnvironment.setState("powerUsage", 450.0);

        // Verify that there is no unusual consumption pattern
        assertFalse(energy.hasUnusualConsumptionPattern(), "There should be no unusual consumption pattern.");

        // Simulate a spike in power usage
        homeEnvironment.setState("powerUsage", 1200.0); // A spike

        // Verify that an unusual consumption pattern is detected
        assertTrue(energy.hasUnusualConsumptionPattern(), "There should be an unusual consumption pattern due to the spike.");
    }

    @Test
    void testUnusualConsumptionPatternWithSpikeDuration() {
        // Simulate normal usage for the first few readings
        homeEnvironment.setState("powerUsage", 350.0);
        homeEnvironment.setState("powerUsage", 450.0);
        homeEnvironment.setState("powerUsage", 400.0);
        homeEnvironment.setState("powerUsage", 500.0);
        homeEnvironment.setState("powerUsage", 600.0);

        // Verify no unusual pattern
        assertFalse(energy.hasUnusualConsumptionPattern(), "Consumption should not be unusual yet.");

        // Simulate a spike in power usage over the next few readings
        homeEnvironment.setState("powerUsage", 1500.0);  // A large spike
        homeEnvironment.setState("powerUsage", 1600.0);  // Another large spike

        // Verify that the spike is detected as unusual consumption pattern
        assertTrue(energy.hasUnusualConsumptionPattern(), "Consumption should be detected as unusual due to the recent spikes.");
    }
}

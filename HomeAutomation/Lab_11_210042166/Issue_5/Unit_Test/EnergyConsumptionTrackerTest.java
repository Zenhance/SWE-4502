package Lab_11_210042166.Issue_5.Unit_Test;
import Lab_11_210042166.Issue_5.EnergyConsumption.EnergyConsumptionTracker;
import Lab_11_210042166.Project_Structure.Storage_Class.EnvironmentState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class EnergyConsumptionTrackerTest {
    private EnergyConsumptionTracker tracker;
    private EnvironmentState state;

    @BeforeEach
    void setUp() {
        tracker = new EnergyConsumptionTracker(2.0);
        state = new EnvironmentState(0.0, false, 0,0);
    }

    @Test
    void testEnergyConsumptionTracking() {
        state.setPowerUsage(5.0);
        tracker.update(state);

        state.setPowerUsage(7.0);
        tracker.update(state);

        state.setPowerUsage(6.0);
        tracker.update(state);

        assertEquals(3, tracker.getUsageHistory().size(), "Usage history should have 3 entries.");
        assertEquals(18.0, tracker.getTotalEnergyConsumed(), "Total energy consumed should be 18.0 kWh.");
    }

    @Test
    void testAverageConsumptionCalculation() {
        state.setPowerUsage(5.0);
        tracker.update(state);
        state.setPowerUsage(7.0);
        tracker.update(state);
        state.setPowerUsage(6.0);
        tracker.update(state);

        assertEquals(6.0, tracker.getAverageConsumption(), 0.01, "Average consumption should be 6.0 kWh.");
    }

    @Test
    void testAnomalyDetection() {
        state.setPowerUsage(5.0);
        tracker.update(state);
        state.setPowerUsage(5.0);
        tracker.update(state);
        state.setPowerUsage(20.0);
        tracker.update(state);

        List<Double> history = tracker.getUsageHistory();
        assertTrue(history.contains(20.0), "Anomalous usage of 20.0 should be recorded.");
    }
}

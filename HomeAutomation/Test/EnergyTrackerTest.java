import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnergyTrackerTest {
    private HomeState homeState;
    private EnergyTracker energyTracker;

    @BeforeEach
    void setUp() {
        homeState = new HomeState();
        energyTracker = new EnergyTracker(homeState);
    }

    @Test
    void testTotalUsageIncreases() {
        energyTracker.setPowerUsage(500);
        energyTracker.setPowerUsage(300);
        assertEquals(800, energyTracker.getTotalUsage());
    }


}
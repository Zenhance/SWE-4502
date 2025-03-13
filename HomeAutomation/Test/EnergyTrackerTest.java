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

    @Test
    void testUnusualWhenHighUsage() {
        energyTracker.setPowerUsage(1200);
        assertTrue(energyTracker.isUnusual());
    }

    @Test
    void testNotUnusualWhenLowUsage() {
        energyTracker.setPowerUsage(800);
        assertFalse(energyTracker.isUnusual());
    }
}
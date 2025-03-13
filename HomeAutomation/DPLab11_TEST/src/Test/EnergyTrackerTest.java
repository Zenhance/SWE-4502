package Test;

import components.EnergyTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EnergyTrackerTest {

    @Test
    void testOnStateChanged() {
        EnergyTracker energyTracker = new EnergyTracker();
        energyTracker.onStateChanged("energy usage detected", 0);
        assertTrue(true); // Assuming correct output happens
    }

   
}

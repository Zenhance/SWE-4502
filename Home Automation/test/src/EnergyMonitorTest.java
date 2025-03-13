import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnergyMonitorTest {

    private EnergyMonitor energyMonitor;

    @BeforeEach
    void setUp() {

        energyMonitor = new EnergyMonitor();
    }

    @Test
    void testUpdateWithPowerUsage() {

        energyMonitor.update("POWER_USAGE", 5.0);

        assertTrue(energyMonitor.detectUnusualUsage() == false, "Usage log should not have any unusual usage yet");

        energyMonitor.update("POWER_USAGE", 15.0);

        assertTrue(energyMonitor.detectUnusualUsage(), "Usage log should have unusual usage");
    }

    @Test
    void testUpdateWithOtherState() {

        energyMonitor.update("TEMPERATURE", 25.0);

        assertFalse(energyMonitor.detectUnusualUsage(), "Usage log should not have any usage when state is not POWER_USAGE");
    }

    @Test
    void testDetectUnusualUsage() {

        energyMonitor.update("POWER_USAGE", 5.0);
        energyMonitor.update("POWER_USAGE", 15.0);

        assertTrue(energyMonitor.detectUnusualUsage(), "Energy monitor should detect unusual usage above the threshold");
    }

    @Test
    void testNoUnusualUsage() {

        energyMonitor.update("POWER_USAGE", 5.0);
        energyMonitor.update("POWER_USAGE", 7.5);

        assertFalse(energyMonitor.detectUnusualUsage(), "Energy monitor should not detect unusual usage below threshold");
    }
}
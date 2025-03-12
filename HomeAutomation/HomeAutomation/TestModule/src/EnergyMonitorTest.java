

import Components.EnergyMonitor;
import Core.EnvironmentState;
import Core.SmartHomeData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EnergyMonitorTest {
    private EnvironmentState envState;
    private SmartHomeData homeData;
    private EnergyMonitor energyMonitor;

    @BeforeEach
    void setUp() {
        envState = new EnvironmentState();
        homeData = new SmartHomeData();
        energyMonitor = new EnergyMonitor(homeData);
        envState.addObserver(energyMonitor);
    }

    @Test
    void testEnergyMonitorReceivesPowerUsageUpdate() {
        envState.setState("POWER_USAGE", 5.5);
        assertDoesNotThrow(() -> homeData.getLatestReading("POWER_USAGE"));
    }

    @Test
    void testEnergyMonitorIgnoresUnrelatedUpdates() {
        envState.setState("TEMPERATURE", 22.0);
        assertThrows(IllegalStateException.class, () -> homeData.getLatestReading("TEMPERATURE"));
    }
}

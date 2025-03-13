import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.EnvironmentState;
import observers.EnergyMonitor;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class EnergyMonitorTest {
    private EnergyMonitor energyMonitor;
    private EnvironmentState environmentState;

    @BeforeEach
    void setUp() {
        energyMonitor = new EnergyMonitor();
        environmentState = new EnvironmentState();
    }

    @Test
    void testUpdateTracksEnergyConsumption() {
        environmentState.setPowerUsage(5.0);
        energyMonitor.update(environmentState);

        assertEquals(5.0, energyMonitor.getTotalEnergyConsumed());
    }

    @Test
    void testUpdateAccumulatesEnergyConsumption() {
        environmentState.setPowerUsage(3.0);
        energyMonitor.update(environmentState);

        environmentState.setPowerUsage(7.0);
        energyMonitor.update(environmentState);

        assertEquals(10.0, energyMonitor.getTotalEnergyConsumed());
    }

    @Test
    void testUsageHistoryIsTracked() {
        environmentState.setPowerUsage(2.5);
        energyMonitor.update(environmentState);

        environmentState.setPowerUsage(3.5);
        energyMonitor.update(environmentState);

        List<Double> history = energyMonitor.getUsageHistory();
        assertEquals(2, history.size());
        assertEquals(2.5, history.get(0));
        assertEquals(3.5, history.get(1));
    }
}

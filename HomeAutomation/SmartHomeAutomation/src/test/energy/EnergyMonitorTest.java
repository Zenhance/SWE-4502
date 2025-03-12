package energy;

import core.StateManager;
import core.model.Measurement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnergyMonitorTest {

    @Test
    void testMonitorPowerUsageUpdatesState() {
        StateManager stateManager = new StateManager();
        EnergyMonitor energyMonitor = new EnergyMonitor(stateManager);

        energyMonitor.monitorPowerUsage(120.0);

        assertEquals(120.0, energyMonitor.getCurrentPowerUsage(), "Current power usage should be updated");
        assertEquals(120.0, energyMonitor.getTotalEnergyConsumed(), "Total energy consumed should be updated");
    }

    @Test
    void testOnEventUpdatesEnergyConsumption() {
        StateManager stateManager = new StateManager();
        EnergyMonitor energyMonitor = new EnergyMonitor(stateManager);

        // Simulate power usage event
        Measurement powerMeasurement = new Measurement(150.0, Measurement.Units.WATT);
        stateManager.setState(core.model.EventType.POWER_USAGE, powerMeasurement);

        assertEquals(150.0, energyMonitor.getCurrentPowerUsage(), "Current power usage should be updated");
        assertEquals(150.0, energyMonitor.getTotalEnergyConsumed(), "Total energy consumed should be updated");
    }

    @Test
    void testGetCurrentPowerUsage() {
        StateManager stateManager = new StateManager();
        EnergyMonitor energyMonitor = new EnergyMonitor(stateManager);

        energyMonitor.monitorPowerUsage(200.0);

        assertEquals(200.0, energyMonitor.getCurrentPowerUsage(), "getCurrentPowerUsage() should return the correct value");
    }

    @Test
    void testGetTotalEnergyConsumed() {
        StateManager stateManager = new StateManager();
        EnergyMonitor energyMonitor = new EnergyMonitor(stateManager);

        energyMonitor.monitorPowerUsage(200.0);
        energyMonitor.monitorPowerUsage(50.0);

        assertEquals(250.0, energyMonitor.getTotalEnergyConsumed(), "getTotalEnergyConsumed() should return the correct value");
    }
}

package energy;

import core.Event;
import core.EventListener;
import core.model.EventType;
import core.StateManager;
import core.model.Measurement;

public class EnergyMonitor implements EventListener {
    private StateManager stateManager;
    private double currentPowerUsage = 0.0;
    private double totalEnergyConsumed = 0.0;
    private boolean updatingFromInternalSource = false;

    public EnergyMonitor(StateManager stateManager) {
        this.stateManager = stateManager;
        stateManager.register(EventType.POWER_USAGE, this);
    }

    public void monitorPowerUsage(double powerUsage) {
        this.currentPowerUsage = powerUsage;
        totalEnergyConsumed += powerUsage;
        updatingFromInternalSource = true;
        Measurement measurement = new Measurement(powerUsage, Measurement.Units.WATT);
        stateManager.setState(EventType.POWER_USAGE, measurement);
        updatingFromInternalSource = false;
    }

    public double getCurrentPowerUsage() {
        return currentPowerUsage;
    }

    public double getTotalEnergyConsumed() {
        return totalEnergyConsumed;
    }

    @Override
    public void onEvent(Event event) {
        if (event.getType() == EventType.POWER_USAGE) {
            currentPowerUsage = ((Measurement) event.getData()).getValue();
            // Only update totalEnergyConsumed if this event didn't come from our own monitorPowerUsage call
            if (!updatingFromInternalSource) {
                totalEnergyConsumed += currentPowerUsage;
            }
        }
    }
}

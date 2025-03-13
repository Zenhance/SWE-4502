package observers;

import java.util.ArrayList;
import java.util.List;

import models.EnvironmentState;

public class EnergyMonitor implements Observer {
    private double totalEnergyConsumed; // Total energy over time
    private List<Double> usageHistory;  // Stores energy consumption over time

    public EnergyMonitor() {
        this.totalEnergyConsumed = 0.0;
        this.usageHistory = new ArrayList<>();
    }

    @Override
    public void update(EnvironmentState environmentState) {
        double currentUsage = environmentState.getPowerUsage();

        // Update total consumption
        totalEnergyConsumed += currentUsage;
        usageHistory.add(currentUsage);
    }

    public double getTotalEnergyConsumed() {
        return totalEnergyConsumed;
    }

    public List<Double> getUsageHistory() {
        return new ArrayList<>(usageHistory);
    }

}

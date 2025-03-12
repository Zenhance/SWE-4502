package Lab_11_210042166.Issue_5.EnergyConsumption;

import Lab_11_210042166.Project_Structure.Interface.Component;
import Lab_11_210042166.Project_Structure.Storage_Class.EnvironmentState;

import java.util.ArrayList;
import java.util.List;

public class EnergyConsumptionTracker implements Component {
    private double currentPowerUsage;
    private final List<Double> usageHistory;
    private double totalEnergyConsumed;
    private double anomalyThreshold;

    // Constructor
    public EnergyConsumptionTracker(double anomalyThreshold) {
        this.usageHistory = new ArrayList<>();
        this.totalEnergyConsumed = 0.0;
        this.anomalyThreshold = anomalyThreshold;
    }

    @Override
    public void update(EnvironmentState state) {
        this.currentPowerUsage = state.getPowerUsage();
        usageHistory.add(currentPowerUsage);

        totalEnergyConsumed += currentPowerUsage;
        detectAnomaly();
    }

    public double getAverageConsumption() {
        if (usageHistory.isEmpty()) return 0;
        return totalEnergyConsumed / usageHistory.size();
    }

    private void detectAnomaly() {
        double average = getAverageConsumption();
        if (currentPowerUsage > average * anomalyThreshold) {
            System.out.println(" Warning: Unusual power consumption detected! Current: "
                    + currentPowerUsage + " kW (Avg: " + average + " kW)");
        }
    }
    public double getCurrentPowerUsage() {
        return currentPowerUsage;
    }

    public double getTotalEnergyConsumed() {
        return totalEnergyConsumed;
    }

    public List<Double> getUsageHistory() {
        return usageHistory;
    }
}

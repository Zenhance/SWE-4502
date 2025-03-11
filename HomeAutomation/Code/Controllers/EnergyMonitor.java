package Code.Controllers;

import Code.Interfaces.Component;
import Code.StateManagementClasses.StateManager;
import java.util.ArrayList;
import java.util.List;

public class EnergyMonitor implements Component {
    private StateManager stateManager;
    private List<Double> powerUsageHistory = new ArrayList<>();
    private double threshold = 4000.0; // Define high usage threshold
    private double totalConsumption = 0.0;

    public EnergyMonitor(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    @Override
    public void onStateChange(String key, Object value) {
        if ("powerUsage".equals(key)) {
            trackEnergyConsumption((Double) value);
        }
    }

    private void trackEnergyConsumption(double powerUsage) {
        powerUsageHistory.add(powerUsage);
        totalConsumption += powerUsage;
        System.out.println("Current Power Usage: " + powerUsage + "W");
        System.out.println("Total Energy Consumed: " + totalConsumption + "Wh");

        if (powerUsage > threshold) {
            System.out.println("Warning: High power usage detected! (" + powerUsage + "W)");
        }
    }

    public double getTotalConsumption() {
        return totalConsumption;
    }

    public boolean isHighConsumption(double powerUsage) {
        return powerUsage > threshold;
    }

    public List<Double> getPowerUsageHistory() {
        return powerUsageHistory;
    }
}

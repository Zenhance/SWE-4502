package lab11_210042164.implementation.features;


import lab11_210042164.implementation.interfaces.Component;
import lab11_210042164.implementation.manager.StateManager;
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
            stateManager.updateState("highPowerUsageAlert", true);
        } else {
            stateManager.updateState("highPowerUsageAlert", false);
        }
    }

    public double getTotalConsumption() {
        return totalConsumption;
    }

    public boolean isHighConsumption(double powerUsage) {
        return powerUsage > threshold;
    }

    public List<Double> getPowerUsageHistory() {
        return new ArrayList<>(powerUsageHistory);
    }

    public double getAveragePowerUsage() {
        if (powerUsageHistory.isEmpty()) {
            return 0.0;
        }

        double sum = 0.0;
        for (Double usage : powerUsageHistory) {
            sum += usage;
        }
        return sum / powerUsageHistory.size();
    }

    public double getMaxPowerUsage() {
        if (powerUsageHistory.isEmpty()) {
            return 0.0;
        }

        double max = Double.MIN_VALUE;
        for (Double usage : powerUsageHistory) {
            if (usage > max) {
                max = usage;
            }
        }
        return max;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }

    public double getThreshold() {
        return threshold;
    }
}
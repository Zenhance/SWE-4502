package EnergyConsumptionTracker;
import CoreFramework.HomeEnvironment;
import CoreFramework.Observer;

import java.util.ArrayList;
import java.util.List;

public class EnergyConsumptionTracker implements Observer{
    private double currentPowerUsage = 0.0;
    private List<Double> usageHistory = new ArrayList<>();
    private double averageUsage = 0.0;

    public EnergyConsumptionTracker() {
        HomeEnvironment.getInstance().registerObserver("powerUsage", this);
    }

    @Override
    public void update(String eventType, Object value) {
        if (eventType.equals("powerUsage") && value instanceof Double) {
            trackConsumption((Double) value);
        }
    }

    public void trackConsumption(double power) {
        this.currentPowerUsage = power;
        usageHistory.add(power);
        calculateStatistics();
    }

    public void calculateStatistics() {
        if (usageHistory.isEmpty()) return;

        double sum = 0;
        for (Double usage : usageHistory) {
            sum += usage;
        }
        averageUsage = sum / usageHistory.size();

        identifyUnusualPatterns();
    }

    public void identifyUnusualPatterns() {
        if (usageHistory.size() < 2) return;

        double latestUsage = usageHistory.get(usageHistory.size() - 1);
        if (latestUsage > averageUsage * 1.5) {
            System.out.println("ALERT: Unusual power consumption detected: " + latestUsage + " watts");
        }
    }

    // Getters
    public double getCurrentPowerUsage() { return currentPowerUsage; }
    public List<Double> getUsageHistory() { return new ArrayList<>(usageHistory); }
    public double getAverageUsage() { return averageUsage; }
}

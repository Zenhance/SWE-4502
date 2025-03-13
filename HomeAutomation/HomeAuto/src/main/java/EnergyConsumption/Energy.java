package EnergyConsumption;

import Core.Observer;
import java.util.ArrayList;
import java.util.List;

public class Energy implements Observer {
    private List<Double> powerUsageData;
    private static final double USUAL_CONSUMPTION_THRESHOLD = 500.0;
    private static final int SPIKE_DURATION = 10;

    public Energy() {
        powerUsageData = new ArrayList<>();
    }

    @Override
    public void update(String eventType, Object value) {
        if (eventType.equals("powerUsage")) {
            double powerUsage = (double) value;
            logPowerUsage(powerUsage);
        }
    }

    // Method to log the power usage
    private void logPowerUsage(double powerUsage) {
        powerUsageData.add(powerUsage);

        if (powerUsageData.size() > 100) {
            powerUsageData.remove(0);
        }
    }

    public double getTotalPowerUsage() {
        double totalUsage = 0;
        for (double usage : powerUsageData) {
            totalUsage += usage;
        }
        return totalUsage;
    }

    public double getAveragePowerUsage() {
        if (powerUsageData.isEmpty()) {
            return 0;
        }
        return getTotalPowerUsage() / powerUsageData.size();
    }

    public double getMaxPowerUsage() {
        if (powerUsageData.isEmpty()) {
            return 0;
        }
        double maxUsage = Double.MIN_VALUE;
        for (double usage : powerUsageData) {
            if (usage > maxUsage) {
                maxUsage = usage;
            }
        }
        return maxUsage;
    }

    public boolean hasUnusualConsumptionPattern() {
        if (powerUsageData.size() < SPIKE_DURATION) {
            return false;
        }

        double recentSpike = 0;
        for (int i = powerUsageData.size() - SPIKE_DURATION; i < powerUsageData.size(); i++) {
            recentSpike += powerUsageData.get(i);
        }

        return recentSpike > USUAL_CONSUMPTION_THRESHOLD * SPIKE_DURATION;
    }

    public List<Double> getPowerUsageData() {
        return powerUsageData;
    }
}

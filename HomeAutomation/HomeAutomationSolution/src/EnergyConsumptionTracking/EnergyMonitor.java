package EnergyConsumptionTracking;

import CoreFramework.*;

import java.util.ArrayList;
import java.util.List;

// Monitors power usage and detects unusual patterns
public class EnergyMonitor implements Observer {
    private List<Integer> powerUsageHistory;
    private int totalUsage;
    private int highThreshold = 5000; // Example: 5000W threshold

    public EnergyMonitor() {
        this.powerUsageHistory = new ArrayList<>();
        this.totalUsage = 0;
    }

    @Override
    public void update(EnvironmentState state) {
        trackEnergyUsage(state.getLightLevel()*10);
    }

    private void trackEnergyUsage(int powerUsage) {
        powerUsageHistory.add(powerUsage);
        totalUsage += powerUsage;

        if (powerUsage > highThreshold) {
            System.out.println("⚠️ Warning: High power consumption detected! (" + powerUsage + "W)");
        }
    }

    public int getTotalUsage() {
        return totalUsage;
    }

    public boolean isHighUsageDetected() {
        return !powerUsageHistory.isEmpty() && powerUsageHistory.get(powerUsageHistory.size() - 1) > highThreshold;
    }
}

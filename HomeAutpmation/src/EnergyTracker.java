import java.util.HashMap;
import java.util.Map;

public class EnergyTracker implements IObserver {

    private Map<String, Integer> energyConsumption = new HashMap<>();
    private String lastAction;
    private int totalConsumption;
    @Override
    public void update(SystemState state) {
        String usageDescription = state.getStateDescription();

        if (usageDescription.equals("Power Consumption Detected")) {
            int consumption = (int) (Math.random() * 100);
            logEnergyConsumption(consumption);
            trackUsageStats(consumption);
        }
    }

    public void logEnergyConsumption(int consumption) {
        lastAction = "Logging energy consumption: " + consumption + " kWh.";
    }

    public void trackUsageStats(int consumption) {
        energyConsumption.put("total", energyConsumption.getOrDefault("total", 0) + consumption);
        totalConsumption = energyConsumption.get("total");

        if (totalConsumption > 500) {
            lastAction = "Unusual consumption pattern detected: " + totalConsumption + " kWh.";
        } else {
            lastAction = "Energy consumption is within normal range.";
        }
    }

    public void resetConsumption() {
        energyConsumption.put("total", 0);
        lastAction = "Energy consumption has been reset.";
        totalConsumption = 0;
    }

    public int getTotalConsumption() {
        return totalConsumption;
    }

    public String getLastAction() {
        return lastAction;
    }
}

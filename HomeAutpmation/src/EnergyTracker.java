import java.util.HashMap;
import java.util.Map;

public class EnergyTracker implements IObserver {

    private Map<String, Integer> energyConsumption = new HashMap<>();

    @Override
    public void update(SystemState state) {
        String usageDescription = state.getStateDescription();

        if (usageDescription.equals("Power Consumption Detected")) {
            int consumption = (int) (Math.random() * 100);
            logEnergyConsumption(consumption);
            trackUsageStats(consumption);

            System.out.println("Current power consumption: " + consumption + " kWh.");
        }
    }

    public void logEnergyConsumption(int consumption) {
        System.out.println("Logging energy consumption: " + consumption + " kWh.");
    }

    public void trackUsageStats(int consumption) {
        energyConsumption.put("total", energyConsumption.getOrDefault("total", 0) + consumption);

        int totalConsumption = energyConsumption.get("total");

        if (totalConsumption > 500) {
            System.out.println("Unusual consumption pattern detected: " + totalConsumption + " kWh.");
        } else {
            System.out.println("Energy consumption is within normal range.");
        }
    }


    public void resetConsumption() {
        energyConsumption.put("total", 0);

    }


    public int getTotalConsumption() {
        return energyConsumption.getOrDefault("total", 0);
    }
}

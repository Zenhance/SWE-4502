import java.util.HashMap;
import java.util.Map;

public class EnergyTracker implements IObserver{

    private Map<String, Integer> energyConsumption = new HashMap<>();

    @Override
    public void update(SystemState state) {

    }

    private void logEnergyConsumption(int consumption) {
        System.out.println("Logging energy consumption: " + consumption + " kWh.");
    }


    private void trackUsageStats(int consumption) {
        energyConsumption.put("total", energyConsumption.getOrDefault("total", 0) + consumption);

        int totalConsumption = energyConsumption.get("total");

        if (totalConsumption > 500) {
            System.out.println("Unusual consumption pattern detected: " + totalConsumption + " kWh.");
        } else {
            System.out.println("Energy consumption is within normal range.");
        }
    }
}

package components;
import core.Sensor;

public class EnergyTracker implements Sensor
{
    @Override
    public void onStateChange(String newState) {
        System.out.println("Monitoring energy usage.");
    }

    //Calculates usage statistics over time
    public void calculateUsageStatistics() {
        System.out.println("Calculating energy usage statistics.");
    }

    //Identifies unusual consumption patterns
    public void identifyUnusualConsumptionPatterns() {
        System.out.println("Identifying unusual energy consumption patterns.");
    }



}

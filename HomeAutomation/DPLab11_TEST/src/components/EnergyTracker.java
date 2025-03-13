package components;

import core.IComponent;

public class EnergyTracker implements IComponent {

    @Override
    public void onStateChanged(String newState, int value) {
        System.out.println("Monitoring energy usage.");
    }

    public void calculateUsageStatistics() {
        System.out.println("Calculating energy usage statistics.");
    }

    public void identifyUnusualConsumptionPatterns() {
        System.out.println("Identifying unusual energy consumption patterns.");
    }
}

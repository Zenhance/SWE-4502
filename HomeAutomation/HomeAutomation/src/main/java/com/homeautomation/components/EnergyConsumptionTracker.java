package com.homeautomation.components;

import com.homeautomation.core.Component;
import com.homeautomation.core.EnvironmentalState;
import java.util.HashMap;
import java.util.Map;

public class EnergyConsumptionTracker implements Component {
    private final Map<String, Double> deviceConsumption;
    private double totalEnergyConsumed;

    public EnergyConsumptionTracker() {
        this.deviceConsumption = new HashMap<>();
        this.totalEnergyConsumed = 0.0;
    }

    @Override
    public void updateState(EnvironmentalState state) {
        for (String device : deviceConsumption.keySet()) {
            totalEnergyConsumed += deviceConsumption.get(device);
        }
    }

    public void addDevice(String deviceName, double powerUsage) {
        deviceConsumption.put(deviceName, powerUsage);
    }

    public void removeDevice(String deviceName) {
        deviceConsumption.remove(deviceName);
    }

    public double getTotalEnergyConsumed() {
        return totalEnergyConsumed;
    }

    public Map<String, Double> getDeviceConsumption() {
        return new HashMap<>(deviceConsumption);
    }
}

package org.example;

import java.time.*;
import java.util.*;

public class EnergyConsumptionSystem implements StateChangeObserver {
    private HomeSystem homeSystem;
    private Map<String, Double> deviceConsumption = new HashMap<>();
    private List<EnergyReading> energyReadings = new ArrayList<>();
    private double totalConsumption = 0.0;

    public EnergyConsumptionSystem(HomeSystem homeSystem) {
        this.homeSystem = homeSystem;
        homeSystem.registerObserver("devicePower", this);

        // Initialize some device power consumption for demo
        deviceConsumption.put("hvac", 2500.0); // watts
        deviceConsumption.put("lighting", 800.0);
        deviceConsumption.put("kitchen", 1200.0);
    }

    @Override
    public void onStateChange(String property, Object oldValue, Object newValue) {
        if (property.equals("devicePower") && newValue instanceof Map) {
            @SuppressWarnings("unchecked")
            Map<String, Boolean> deviceStatus = (Map<String, Boolean>)newValue;
            recordConsumption(deviceStatus);
        }
    }

    public void recordConsumption(Map<String, Boolean> deviceStatus) {
        double currentUsage = 0.0;

        for (Map.Entry<String, Boolean> entry : deviceStatus.entrySet()) {
            String device = entry.getKey();
            boolean isOn = entry.getValue();

            if (isOn && deviceConsumption.containsKey(device)) {
                currentUsage += deviceConsumption.get(device);
            }
        }

        // Convert watts to kilowatt-hours (assuming 1 hour period for simplicity)
        double kwhUsage = currentUsage / 1000.0;
        totalConsumption += kwhUsage;

        EnergyReading reading = new EnergyReading(LocalDateTime.now(), kwhUsage, deviceStatus);
        energyReadings.add(reading);

        System.out.println("Current power usage: " + currentUsage + "W (" + kwhUsage + " kWh)");
        System.out.println("Total consumption: " + totalConsumption + " kWh");

        // Check for unusual patterns (simple demo - just high consumption)
        if (currentUsage > 3000) {
            System.out.println("ALERT: Unusually high power consumption detected!");
        }
    }

    // Inner class for energy readings
    private static class EnergyReading {
        private LocalDateTime time;
        private double kwhUsage;
        private Map<String, Boolean> deviceStatus;

        public EnergyReading(LocalDateTime time, double kwhUsage, Map<String, Boolean> deviceStatus) {
            this.time = time;
            this.kwhUsage = kwhUsage;
            this.deviceStatus = new HashMap<>(deviceStatus);
        }

        public LocalDateTime getTime() { return time; }
        public double getKwhUsage() { return kwhUsage; }
        public Map<String, Boolean> getDeviceStatus() { return deviceStatus; }
    }
}
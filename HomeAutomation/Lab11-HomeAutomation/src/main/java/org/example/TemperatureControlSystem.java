package org.example;

public class TemperatureControlSystem implements StateChangeObserver {
    private HomeSystem homeSystem;
    private double targetTemperature = 22.0; // Default target in Celsius
    private double hysteresis = 1.0; // 1 degree hysteresis
    private boolean heatingOn = false;
    private boolean coolingOn = false;

    public TemperatureControlSystem(HomeSystem homeSystem) {
        this.homeSystem = homeSystem;
        homeSystem.registerObserver("temperature", this);
        homeSystem.registerObserver("targetTemperature", this);
    }

    @Override
    public void onStateChange(String property, Object oldValue, Object newValue) {
        if (property.equals("temperature") && newValue instanceof Double) {
            adjustHVAC((Double)newValue);
        }
        else if (property.equals("targetTemperature") && newValue instanceof Double) {
            targetTemperature = (Double)newValue;
            System.out.println("Target temperature updated to " + targetTemperature + "°C");

            // Check current temperature to update HVAC if needed
            Object currentTemp = homeSystem.getStateValue("temperature");
            if (currentTemp instanceof Double) {
                adjustHVAC((Double)currentTemp);
            }
        }
    }

    public void adjustHVAC(double currentTemperature) {
        System.out.println("Current temperature: " + currentTemperature + "°C, Target: " + targetTemperature + "°C");

        // Check if we need heating
        if (currentTemperature < (targetTemperature - hysteresis) && !heatingOn) {
            heatingOn = true;
            coolingOn = false;
            System.out.println("Heating system activated");
        }
        // Check if we need cooling
        else if (currentTemperature > (targetTemperature + hysteresis) && !coolingOn) {
            coolingOn = true;
            heatingOn = false;
            System.out.println("Cooling system activated");
        }
        // Check if we can turn off systems
        else if (currentTemperature >= targetTemperature && heatingOn) {
            heatingOn = false;
            System.out.println("Heating system deactivated");
        }
        else if (currentTemperature <= targetTemperature && coolingOn) {
            coolingOn = false;
            System.out.println("Cooling system deactivated");
        }
    }

    public boolean isHeatingOn() { return heatingOn; }
    public boolean isCoolingOn() { return coolingOn; }
    public double getTargetTemperature() { return targetTemperature; }
}
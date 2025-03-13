package com.homeautomation.components;

import com.homeautomation.core.Component;
import com.homeautomation.core.EnvironmentalState;

public class TemperatureControl implements Component {
    private double currentTemperature;
    private double targetTemperature;
    private boolean heatingOn;
    private boolean coolingOn;

    public TemperatureControl(double targetTemperature) {
        this.targetTemperature = targetTemperature;
        this.heatingOn = false;
        this.coolingOn = false;
    }

    @Override
    public void updateState(EnvironmentalState state) {
        this.currentTemperature = state.getTemperature();
        adjustTemperature();
    }

    private void adjustTemperature() {
        if (currentTemperature < targetTemperature - 1) {
            heatingOn = true;
            coolingOn = false;
        } else if (currentTemperature > targetTemperature + 1) {
            coolingOn = true;
            heatingOn = false;
        } else {
            heatingOn = false;
            coolingOn = false;
        }
    }

    public boolean isHeatingOn() {
        return heatingOn;
    }

    public boolean isCoolingOn() {
        return coolingOn;
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }
}

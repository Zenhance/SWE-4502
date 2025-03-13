package TemperatureControl;

import CoreFramework.*;

// TemperatureController manages heating and cooling
public class TemperatureController implements Observer {
    private int targetTemperature;
    private boolean heatingOn;
    private boolean coolingOn;
    private static final int HYSTERESIS = 2; // Avoid rapid HVAC cycling

    public TemperatureController(int targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    @Override
    public void update(EnvironmentState state) {
        adjustTemperature(state.getTemperature());
    }

    private void adjustTemperature(int currentTemperature) {
        if (currentTemperature < targetTemperature - HYSTERESIS) {
            heatingOn = true;
            coolingOn = false;
        } else if (currentTemperature > targetTemperature + HYSTERESIS) {
            heatingOn = false;
            coolingOn = true;
        } else {
            heatingOn = false;
            coolingOn = false;
        }
        System.out.println("Heating: " + heatingOn + ", Cooling: " + coolingOn);
    }

    public boolean isHeatingOn() {
        return heatingOn;
    }

    public boolean isCoolingOn() {
        return coolingOn;
    }
}

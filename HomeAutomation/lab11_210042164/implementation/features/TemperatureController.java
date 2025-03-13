package lab11_210042164.implementation.features;

import lab11_210042164.implementation.interfaces.Component;
import lab11_210042164.implementation.manager.StateManager;

public class TemperatureController implements Component {
    private StateManager stateManager;
    private double currentTemperature = 22.0;
    private double targetTemperature = 22.0;
    private double hysteresis = 0.5;
    private boolean heatingOn = false;
    private boolean coolingOn = false;

    public TemperatureController(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    @Override
    public void onStateChange(String key, Object value) {
        switch (key) {
            case "currentTemperature":
                updateCurrentTemperature((Double) value);
                break;
            case "targetTemperature":
                updateTargetTemperature((Double) value);
                break;
        }
    }

    private void updateCurrentTemperature(double temperature) {
        this.currentTemperature = temperature;
        System.out.println("Current temperature updated to: " + temperature + "°C");
        adjustHVAC();
    }

    private void updateTargetTemperature(double temperature) {
        this.targetTemperature = temperature;
        System.out.println("Target temperature updated to: " + temperature + "°C");
        adjustHVAC();
    }

    private void adjustHVAC() {
        // Determine if heating or cooling is needed with hysteresis

        // Need heating
        if (currentTemperature < (targetTemperature - hysteresis)) {
            if (!heatingOn) {
                heatingOn = true;
                coolingOn = false;
                System.out.println("Heating turned ON");
                stateManager.updateState("heatingStatus", true);
                stateManager.updateState("coolingStatus", false);
            }
        }
        // Need cooling
        else if (currentTemperature > (targetTemperature + hysteresis)) {
            if (!coolingOn) {
                coolingOn = true;
                heatingOn = false;
                System.out.println("Cooling turned ON");
                stateManager.updateState("heatingStatus", false);
                stateManager.updateState("coolingStatus", true);
            }
        }
        // Temperature is within acceptable range
        else if ((currentTemperature >= targetTemperature - hysteresis) &&
                (currentTemperature <= targetTemperature + hysteresis)) {
            if (heatingOn || coolingOn) {
                heatingOn = false;
                coolingOn = false;
                System.out.println("HVAC turned OFF");
                stateManager.updateState("heatingStatus", false);
                stateManager.updateState("coolingStatus", false);
            }
        }
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public double getTargetTemperature() {
        return targetTemperature;
    }

    public boolean isHeatingOn() {
        return heatingOn;
    }

    public boolean isCoolingOn() {
        return coolingOn;
    }

    public double getHysteresis() {
        return hysteresis;
    }

    public void setHysteresis(double hysteresis) {
        this.hysteresis = hysteresis;
    }
}
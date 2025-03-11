package Code.Controllers;

import Code.Interfaces.Component;
import Code.StateManagementClasses.StateManager;

public class TemperatureController implements Component {
    private StateManager stateManager;
    private double targetTemperature = 22.0; // Default target temperature
    private double hysteresis = 1.0; // Prevent rapid cycling (±1°C)
    private boolean heatingOn = false;
    private boolean coolingOn = false;

    public TemperatureController(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    @Override
    public void onStateChange(String key, Object value) {
        if ("temperature".equals(key)) {
            controlTemperature((Double) value);
        } else if ("targetTemperature".equals(key)) {
            this.targetTemperature = (Double) value;
            System.out.println("Target temperature set to: " + targetTemperature);
        }
    }

    private void controlTemperature(double currentTemperature) {
        if (currentTemperature < targetTemperature - hysteresis) {
            activateHeating();
        } else if (currentTemperature > targetTemperature + hysteresis) {
            activateCooling();
        } else {
            turnOffHVAC();
        }
    }

    private void activateHeating() {
        if (!heatingOn) {
            heatingOn = true;
            coolingOn = false;
            System.out.println("Heating activated.");
        }
    }

    private void activateCooling() {
        if (!coolingOn) {
            coolingOn = true;
            heatingOn = false;
            System.out.println("Cooling activated.");
        }
    }

    private void turnOffHVAC() {
        if (heatingOn || coolingOn) {
            heatingOn = false;
            coolingOn = false;
            System.out.println("HVAC system turned off.");
        }
    }

    public boolean isHeatingOn() {
        return heatingOn;
    }

    public boolean isCoolingOn() {
        return coolingOn;
    }

    public double getTargetTemperature() {
        return targetTemperature;
    }
}
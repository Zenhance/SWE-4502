package observers;

import models.EnvironmentState;

public class HVACController implements Observer {
    private boolean heatingOn;
    private boolean coolingOn;
    private double targetTemperature;
    private double hysteresisRange = 1.5;

    public HVACController(double targetTemperature) {
        this.targetTemperature = targetTemperature;
        this.heatingOn = false;
        this.coolingOn = false;
    }
    
    @Override
    public void update(EnvironmentState environmentState) {
        double currentTemperature = environmentState.getTemperature();

        if (currentTemperature < targetTemperature - hysteresisRange) {
            heatingOn = true;
            coolingOn = false;
        } else if (currentTemperature > targetTemperature + hysteresisRange) {
            heatingOn = false;
            coolingOn = true;
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

    public void setTargetTemperature(double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    public double getTargetTemperature() {
        return targetTemperature;
    }
}

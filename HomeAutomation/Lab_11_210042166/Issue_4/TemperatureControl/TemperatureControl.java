package Lab_11_210042166.Issue_4.TemperatureControl;

import Lab_11_210042166.Project_Structure.Interface.Component;
import Lab_11_210042166.Project_Structure.Storage_Class.EnvironmentState;

public class TemperatureControl implements Component {
    private double currentTemperature;
    private double targetTemperature;
    private boolean isHeating;
    private boolean isCooling;
    private double hysteresisRange;
    public TemperatureControl(double targetTemperature, double hysteresisRange) {
        this.targetTemperature = targetTemperature;
        this.hysteresisRange = hysteresisRange;
        this.isHeating = false;
        this.isCooling = false;
    }

    @Override
    public void update(EnvironmentState state) {
        this.currentTemperature = state.getTemperature();
        if (currentTemperature < targetTemperature - hysteresisRange && !isHeating) {
            activateHeating();
        } else if (currentTemperature > targetTemperature + hysteresisRange && !isCooling) {
            activateCooling();
        } else if (currentTemperature >= targetTemperature - hysteresisRange && currentTemperature <= targetTemperature + hysteresisRange) {
            deactivateHVAC();
        }
    }
    private void activateHeating() {
        isHeating = true;
        isCooling = false;
        System.out.println("Heating activated.");
    }
    private void activateCooling() {
        isCooling = true;
        isHeating = false;
        System.out.println("Cooling activated.");
    }
    private void deactivateHVAC() {
        isHeating = false;
        isCooling = false;
        System.out.println("HVAC deactivated.Temperature is within acceptable range.");
    }
    public boolean isHeating() {
        return isHeating;
    }

    public boolean isCooling() {
        return isCooling;
    }
    public double getCurrentTemperature() {
        return currentTemperature;
    }






}

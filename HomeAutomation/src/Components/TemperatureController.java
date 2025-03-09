package Components;

import Core_Models.IObserver;
import Core_Models.SystemState;

public class TemperatureController implements IObserver {
    public static final int hysteresis = 2;

    public boolean isHeating = false;
    public boolean isCooling = false;
    public int targetTemperature;

    @Override
    public void update(SystemState state) {
        int currentTemp = state.temperature;
        controlTemperature(currentTemp);
    }

    public void setTargetTemperature(int targetTemperature)
    {
        this.targetTemperature = targetTemperature;
    }

    private void controlTemperature(int currentTemp) {
        if (currentTemp < targetTemperature - hysteresis) {
            isHeating = true;
            isCooling = false;
            System.out.println("Heating activated.");
        } else if (currentTemp > targetTemperature + hysteresis) {
            isHeating = false;
            isCooling = true;
            System.out.println("Cooling activated.");
        }
        else {
            isHeating = false;
            isCooling = false;
            System.out.println("Temperature is normal.");
        }
    }

}

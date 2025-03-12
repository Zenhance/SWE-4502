package Components;

import Core.Observer;
import Core.SmartHomeData;

public class TemperatureController implements Observer {
    private final SmartHomeData homeData;
    private double targetTemperature = 22.0;
    private boolean heatingOn = false;
    private boolean coolingOn = false;
    private static final double HYSTERESIS = 1.0;

    public TemperatureController(SmartHomeData homeData) {
        this.homeData = homeData;
    }

    @Override
    public void update(String state, Object value) {
        if ("TEMPERATURE".equals(state)) {
            double temp = (Double) value;
            homeData.addReading("TEMPERATURE", temp);

            if (temp < targetTemperature - HYSTERESIS) {
                heatingOn = true;
                coolingOn = false;
            } else if (temp > targetTemperature + HYSTERESIS) {
                heatingOn = false;
                coolingOn = true;
            } else {
                heatingOn = false;
                coolingOn = false;
            }

            System.out.println("TemperatureController: Current temperature " + temp);
            System.out.println("Heater: " + (heatingOn ? "ON" : "OFF") + ", AC: " + (coolingOn ? "ON" : "OFF"));
        }
    }

    public boolean isHeatingOn() {
        return heatingOn;
    }

    public boolean isCoolingOn() {
        return coolingOn;
    }

    public void setTargetTemperature(double temperature) {
        this.targetTemperature = temperature;
    }
}

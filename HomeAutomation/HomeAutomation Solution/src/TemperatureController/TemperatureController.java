package TemperatureController;
import CoreFramework.*;

public class TemperatureController implements Observer {
    private double currentTemperature = 22.0;
    private double targetTemperature = 22.0;
    private boolean heatingOn = false;
    private boolean coolingOn = false;
    private final double HYSTERESIS = 0.5;

    public TemperatureController() {
        HomeEnvironment.getInstance().registerObserver("temperature", this);
        HomeEnvironment.getInstance().registerObserver("targetTemperature", this);
    }

    @Override
    public void update(String eventType, Object value) {
        if (eventType.equals("temperature") && value instanceof Double) {
            setCurrentTemperature((Double) value);
        } else if (eventType.equals("targetTemperature") && value instanceof Double) {
            setTargetTemperature((Double) value);
        }
    }

    public void setCurrentTemperature(double temperature) {
        this.currentTemperature = temperature;
        adjustTemperature();
    }

    public void setTargetTemperature(double temperature) {
        this.targetTemperature = temperature;
        adjustTemperature();
    }

    public void adjustTemperature() {
        if (currentTemperature < targetTemperature - HYSTERESIS && !heatingOn) {
            heatingOn = true;
            coolingOn = false;
            System.out.println("Heating turned ON");
        } else if (currentTemperature > targetTemperature + HYSTERESIS && !coolingOn) {
            coolingOn = true;
            heatingOn = false;
            System.out.println("Cooling turned ON");
        } else if (currentTemperature >= targetTemperature && heatingOn) {
            heatingOn = false;
            System.out.println("Heating turned OFF");
        } else if (currentTemperature <= targetTemperature && coolingOn) {
            coolingOn = false;
            System.out.println("Cooling turned OFF");
        }
    }

    // Getters
    public double getCurrentTemperature() { return currentTemperature; }
    public double getTargetTemperature() { return targetTemperature; }
    public boolean isHeatingOn() { return heatingOn; }
    public boolean isCoolingOn() { return coolingOn; }
}

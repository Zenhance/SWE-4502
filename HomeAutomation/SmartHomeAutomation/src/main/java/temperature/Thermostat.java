package temperature;

import core.Event;
import core.EventListener;
import core.model.EventType;
import core.StateManager;
import core.model.Measurement;

public class Thermostat implements EventListener {
    private StateManager stateManager;
    private double targetTemperature = 22.0;
    private double currentTemperature = 20.0;
    private double hysteresis = 1.0;
    private boolean heating = false;
    private boolean cooling = false;

    public Thermostat(StateManager stateManager) {
        this.stateManager = stateManager;
        stateManager.register(EventType.TEMPERATURE, this);
        adjustTemperature();
    }

    public void setTargetTemperature(double targetTemperature) {
        this.targetTemperature = targetTemperature;
        adjustTemperature();
    }

    public double getTargetTemperature() {
        return targetTemperature;
    }

    public void adjustTemperature() {
        if (currentTemperature < targetTemperature - hysteresis && !heating) {
            startHeating();
        } else if (currentTemperature > targetTemperature + hysteresis && !cooling) {
            startCooling();
        } else if (currentTemperature >= targetTemperature - hysteresis && currentTemperature <= targetTemperature + hysteresis) {
            stopHeatingCooling();
        }
    }

    private void startHeating() {
        heating = true;
        cooling = false;
        Measurement measurement = new Measurement(1, Measurement.Units.BOOLEAN);
        stateManager.setState(EventType.HEATING_STATUS, measurement);
    }

    private void startCooling() {
        cooling = true;
        heating = false;
        Measurement measurement = new Measurement(1, Measurement.Units.BOOLEAN);
        stateManager.setState(EventType.COOLING_STATUS, measurement);
    }

    private void stopHeatingCooling() {
        heating = false;
        cooling = false;
        Measurement measurement = new Measurement(0, Measurement.Units.BOOLEAN);
        stateManager.setState(EventType.HEATING_STATUS, measurement);
        measurement = new Measurement(0, Measurement.Units.BOOLEAN);
        stateManager.setState(EventType.COOLING_STATUS, measurement);
    }

    @Override
    public void onEvent(Event event) {
        if (event.getType() == EventType.TEMPERATURE) {
            currentTemperature = ((Measurement) event.getData()).getValue();
            adjustTemperature();
        }
    }
}

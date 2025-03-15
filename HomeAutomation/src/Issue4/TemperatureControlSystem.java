package Issue4;

import Issue1.StateManager;

public class TemperatureControlSystem {
    private final TemperatureSensor sensor;
    private final HVACController controller;


    public TemperatureControlSystem(double targetTemperature, double hysteresis) {
        StateManager stateManager = new StateManager();
        this.sensor = new TemperatureSensor(stateManager);
        this.controller = new HVACController(stateManager, targetTemperature, hysteresis);

    }

    public void setCurrentTemperature(double temperature) {
        sensor.readTemperature(temperature);
    }
}

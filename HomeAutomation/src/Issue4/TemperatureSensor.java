package Issue4;

import Issue1.StateManager;

public class TemperatureSensor {
    private final StateManager stateManager;
    public static final String TEMP_KEY = "temperature";

    public TemperatureSensor(StateManager stateManager) {
        this.stateManager = stateManager;
    }


    public void readTemperature(double temperature) {
        System.out.println("Sensor reading: " + temperature + "°C");
        stateManager.updateState(TEMP_KEY, temperature);
    }
}

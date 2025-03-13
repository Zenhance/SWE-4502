package components;

import core.IComponent;

public class TemperatureController implements IComponent {
    private int currentTemperature;

    public TemperatureController() {
        this.currentTemperature = 25; // Default temperature
    }

    @Override
    public void onStateChanged(String newState, int value) {
        if (newState.contains("cold")) {
            System.out.println("It's cold. Turning on heating.");
        } else if (newState.contains("hot")) {
            System.out.println("It's hot. Turning on cooling.");
        }
    }

    public void onTemperatureChange(int newTemperature) {
        this.currentTemperature = newTemperature;
        if (newTemperature < 20) {
            System.out.println("It's cold. Turning on heating.");
        } else if (newTemperature > 30) {
            System.out.println("It's hot. Turning on cooling.");
        }
    }

    public int getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(int temperature) {
        this.currentTemperature = temperature;
    }
}

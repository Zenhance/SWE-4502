package observers;

import models.EnvironmentState;
import subjects.HomeAutomationSystem;

public class RemoteAccessApp implements Observer {
    private HomeAutomationSystem homeAutomationSystem;

    public RemoteAccessApp(HomeAutomationSystem homeAutomationSystem) {
        this.homeAutomationSystem = homeAutomationSystem;
        this.homeAutomationSystem.registerObserver(this);
    }

    @Override
    public void update(EnvironmentState state) {
        displayCurrentState(state);
        generateNotifications(state);
    }

    private void displayCurrentState(EnvironmentState state) {
        System.out.println("Current Temperature: " + state.getTemperature());
        System.out.println("Current Light Level: " + state.getLightLevel());
        System.out.println("Current Power Usage: " + state.getPowerUsage());
    }

    private void generateNotifications(EnvironmentState state) {
        if (state.getTemperature() > 30) {
            System.out.println("Warning: High Temperature!");
        } else if (state.getTemperature() < 15) {
            System.out.println("Warning: Low Temperature!");
        }
    }

    public void controlLights(boolean turnOn) {
        if (turnOn) {
            homeAutomationSystem.getEnvironmentState().setLightLevel(100);
        } else {
            homeAutomationSystem.getEnvironmentState().setLightLevel(0);
        }
    }

    public void controlTemperature(double newTemperature) {
        homeAutomationSystem.getEnvironmentState().setTemperature(newTemperature);
    }
}

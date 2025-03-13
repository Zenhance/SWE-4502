package com.homeautomation.components;

import com.homeautomation.core.Component;
import com.homeautomation.core.EnvironmentalState;

import java.util.ArrayList;
import java.util.List;

public class VoiceCommandSystem {
    private final List<Component> components = new ArrayList<>();

    public void registerComponent(Component component) {
        components.add(component);
    }

    public void removeComponent(Component component) {
        components.remove(component);
    }

    public void processVoiceCommand(String command) {
        EnvironmentalState state = new EnvironmentalState();

        switch (command.toLowerCase()) {
            case "turn on lights":
                state.setLightLevel(100);
                break;
            case "turn off lights":
                state.setLightLevel(0);
                break;
            case "increase temperature":
                state.setTemperature(state.getTemperature() + 2);
                break;
            case "decrease temperature":
                state.setTemperature(state.getTemperature() - 2);
                break;
            default:
                System.out.println("Unknown command: " + command);
                return;
        }

        notifyComponents(state);
    }

    private void notifyComponents(EnvironmentalState state) {
        for (Component component : components) {
            component.updateState(state);
        }
    }
}

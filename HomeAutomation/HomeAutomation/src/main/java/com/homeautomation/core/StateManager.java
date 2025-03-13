package com.homeautomation.core;

import java.util.ArrayList;
import java.util.List;

public class StateManager {
    private final List<Component> components = new ArrayList<>();
    private EnvironmentalState currentState;

    // Register a component to be notified when the state changes
    public void registerComponent(Component component) {
        components.add(component);
    }

    // Unregister a component
    public void unregisterComponent(Component component) {
        components.remove(component);
    }

    // Update the state and notify all registered components
    public void updateState(EnvironmentalState state) {
        this.currentState = state;
        for (Component component : components) {
            component.updateState(state);
        }
    }

    public EnvironmentalState getCurrentState() {
        return currentState;
    }
}

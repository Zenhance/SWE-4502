package core;

import components.HomeComponent;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CoreSystem {
    public Map<String, Integer> environmentStates;
    public Set<HomeComponent> registeredComponents;

    public CoreSystem() {
        environmentStates = new HashMap<>();
        registeredComponents = new HashSet<>();
    }

    public void registerComponent(HomeComponent component) {
        registeredComponents.add(component);
    }

    public void changeState(String state, int value) {
        environmentStates.put(state, value);
        notifyComponents(state, value);
    }

    public int getState(String state) {
        return environmentStates.getOrDefault(state, 0);
    }

    private void notifyComponents(String state, int value) {
        for (HomeComponent component : registeredComponents) {
            component.onStateChange(state, value);
        }
    }
}


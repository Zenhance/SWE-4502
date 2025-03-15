package org.example;
import java.util.*;

// Central state management system
public class HomeSystem {
    private EnvironmentalState state = new EnvironmentalState();
    private Map<String, List<StateChangeObserver>> observers = new HashMap<>();

    public void registerObserver(String property, StateChangeObserver observer) {
        observers.computeIfAbsent(property, k -> new ArrayList<>()).add(observer);
        System.out.println("Observer registered for property: " + property);
    }

    public void updateState(String property, Object value) {
        Object oldValue = state.getValue(property);
        state.setValue(property, value);

        // Notify relevant observers
        if (observers.containsKey(property)) {
            for (StateChangeObserver observer : observers.get(property)) {
                observer.onStateChange(property, oldValue, value);
            }
        }

        // Also notify observers interested in all changes
        if (observers.containsKey("all")) {
            for (StateChangeObserver observer : observers.get("all")) {
                observer.onStateChange(property, oldValue, value);
            }
        }

        System.out.println("State updated: " + property + " = " + value);
    }

    public Object getStateValue(String property) {
        return state.getValue(property);
    }

    public EnvironmentalState getFullState() {
        return state;
    }
}
package main.models;

import java.util.HashMap;
import java.util.Map;

public class EnvironmentalState {
    private Map<String, Object> states = new HashMap<>();

    public void setState(String key, Object value) {
        states.put(key, value);
        System.out.println("State updated: " + key + " = " + value);
    }

    public Object getState(String key) {
        return states.get(key);
    }

    public Map<String, Object> getAllStates() {
        return new HashMap<>(states);
    }
}
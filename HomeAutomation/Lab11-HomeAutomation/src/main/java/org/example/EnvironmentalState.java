package org.example;
import java.util.*;

// Environmental State class to hold all measurements
public class EnvironmentalState {
    private Map<String, Object> stateValues = new HashMap<>();

    public void setValue(String key, Object value) {
        stateValues.put(key, value);
    }

    public Object getValue(String key) {
        return stateValues.get(key);
    }

    public Map<String, Object> getAllValues() {
        return Collections.unmodifiableMap(stateValues);
    }
}
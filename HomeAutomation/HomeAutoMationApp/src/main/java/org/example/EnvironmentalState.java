package org.example;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class EnvironmentalState {
    private boolean motionDetected;
    private String location;
    private LocalDateTime timestamp;
    private Map<String, Double> measurements = new HashMap<>();

    // Getters and setters
    public void addMeasurement(String type, double value) {
        measurements.put(type, value);
    }
}


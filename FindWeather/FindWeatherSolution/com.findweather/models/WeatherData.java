package com.findweather.models;

public class WeatherData {
    private String location, condition, source;
    private double temperature;
    private long timestamp;

    // Constructor to initialize the WeatherData object
    public WeatherData(String location, double temp, String condition, String source) {
        this.location = location;
        this.temperature = temp;
        this.condition = condition;
        this.source = source;
    }

    // Getters for other fields
    public double getTemperature() {
        return temperature;
    }

    public String getCondition() {
        return condition;
    }

    public String getSource() {
        return source;
    }

    // Setter for timestamp
    public void setTimestamp(long time) {
        this.timestamp = time;
    }

    // Getter for timestamp (added)
    public long getTimestamp() {
        return timestamp;
    }
}

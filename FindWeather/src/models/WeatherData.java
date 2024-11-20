package models;

public class WeatherData {
    private double temperature;
    private String conditions;
    private String location;
    private String source;
    private long timestamp;

    public WeatherData(double temperature, String conditions, String location, String source) {
        this.temperature = temperature;
        this.conditions = conditions;
        this.location = location;
        this.source = source;
        this.timestamp = System.currentTimeMillis();
    }
}

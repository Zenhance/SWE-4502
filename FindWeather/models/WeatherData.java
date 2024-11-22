package models;
public class WeatherData{
    private String location;
    private double temperature;
    private String conditions;
    private String source;
    public WeatherData(String location, double temperature, String conditions, String source)
    {
        this.location = location;
        this.temperature = temperature;
        this.conditions = conditions;
        this.source = source;
    }
    public String getLocation() {
        return location;
    }
    public double getTemperature() {
        return temperature;
    }
    public String getConditions() {
        return conditions;
    }
    public String getSource() {
        return source;
    }
}
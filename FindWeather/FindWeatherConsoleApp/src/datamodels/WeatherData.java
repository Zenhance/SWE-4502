package datamodels;

public class WeatherData {
    private double temperature;
    private String weatherConditions;
    private LocationData location;
    private String dataSource;

    public WeatherData(double temperature, String weatherConditions, LocationData location, String dataSource) {
        this.temperature = temperature;
        this.weatherConditions = weatherConditions;
        this.location = location;
        this.dataSource = dataSource;
    }

    public double getTemperature()
    {
        return temperature;
    }
    public String getWeatherConditions()
    {
        return weatherConditions;
    }
    public LocationData getLocation()
    {
        return location;
    }
    public String getDataSource()
    {
        return dataSource;
    }
}

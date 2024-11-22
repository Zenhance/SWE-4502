package Models;

public class WeatherData {
    private final String location;
    private final String source;
    private final double temperature;
    private final String conditions;

    public WeatherData(String location, String source, double temperature, String conditions) {
        this.location = location;
        this.source = source;
        this.temperature = temperature;
        this.conditions = conditions;
    }

    public String getLocation() {
        return location;
    }

    public String getSource() {
        return source;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getConditions() {
        return conditions;
    }

}

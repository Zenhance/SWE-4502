public class WeatherData {
    String temperature;
     String condition;
     String source;

    public WeatherData(String temperature, String condition, String source) {
        this.temperature = temperature;
        this.condition = condition;
        this.source = source;
    }

    @Override
    public String toString() {
        return "Source: " + source + ", Temperature: " + temperature + "°C, Condition: " + condition;
    }
}

package concreteClasses;

public class WeatherData {
    private String cityName;
    private double latitude;
    private double longitude;
    private double temperature;
    private String weatherCondition;
    private String dataSource;

    public WeatherData(String cityName, double lattitude, double longitude, double temperature, String weatherCondition, String dataSource){
        this.cityName = cityName;
        this.latitude = lattitude;
        this. longitude = longitude;
        this.temperature = temperature;
        this.weatherCondition = weatherCondition;
        this.dataSource = dataSource;
    }
}

import org.json.JSONObject;

public class WeatherData {
    private String cityName;
    private double latitude;
    private double longitude;
    private double temperature;
    private String weatherCondition;
    private String dataSource;
    private String fetchedTime;

    public WeatherData(String cityName, double lattitude, double longitude, double temperature, String weatherCondition, String dataSource){
        this.cityName = cityName;
        this.latitude = lattitude;
        this. longitude = longitude;
        this.temperature = temperature;
        this.weatherCondition = weatherCondition;
        this.dataSource = dataSource;
    }

    public String getCityName(){
        return  cityName;
    }
    public String getTime(){
        return fetchedTime;
    }
    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getTemperature() {
        return temperature;
    }
    public String getWeatherCondition(){
        return weatherCondition;
    }
    public String getDataSource(){
        return dataSource;
    }

    


package adapter;
import models.WeatherData;
public interface WeatherProvider{
    WeatherData getWeatherByIP(double latitude, double longitude) throws Exception;
    WeatherData getWeatherByCity(String city) throws Exception;
}
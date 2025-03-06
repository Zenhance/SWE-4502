package Services;

import Models.WeatherData;
import Proxy.WeatherProxy;

public class WeatherService {
    private final WeatherProxy weatherProxy;

    public WeatherService() {
        this.weatherProxy = new WeatherProxy();
    }

    public void fetchWeather(String city, double latitude, double longitude) {
        WeatherData weatherData = weatherProxy.getWeather(city, latitude, longitude);
        if (weatherData != null) {
            System.out.printf("Weather in %s from %s:%n", weatherData.getLocation(), weatherData.getSource());
            System.out.printf("%.1f°C, %s%n", weatherData.getTemperature(), weatherData.getConditions());
        } else {
            System.out.println("Could not fetch weather data.");
        }
    }
}

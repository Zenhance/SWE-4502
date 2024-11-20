package WeatherServices;

import java.time.Instant;

import Models.WeatherData;
import Utils.WeatherCache;

public class OpenWeatherProxy implements IWeatherProvider {
    private final OpenWeatherProvider provider = new OpenWeatherProvider();
    private final WeatherCache weatherCache = WeatherCache.getInstance();

    @Override
    public WeatherData getWeatherData(String location) {
        // cache theke khuje return krbe
        WeatherData cachedData = weatherCache.retrieve(location);
        if (cachedData != null) {
            System.out.println("Data retrieved from cache for location: " + location);
            return cachedData;
        }

        // cache e na paile api diye fetch krbe
        WeatherData weatherData = provider.getWeatherData(location);
        if (weatherData != null) {
            weatherCache.store(location, weatherData);
            System.out.println("Data fetched from OpenWeather API for location: " + location);
        }
        return weatherData;
    }
    
    
}

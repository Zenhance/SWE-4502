package WeatherServices;

import Models.WeatherData;
import Utils.WeatherCache;

public class WeatherStackProxy implements IWeatherProvider{
    private final WeatherStackProvider provider = new WeatherStackProvider();
    private final WeatherCache weatherCache = WeatherCache.getInstance();
    
    
    @Override
    public WeatherData getWeatherData(String location) {
        WeatherData cachedData = weatherCache.retrieve(location);
        if (cachedData != null) {
            System.out.println("Data retrieved from cache for location: " + location);
            return cachedData;
        }

        
        WeatherData weatherData = provider.getWeatherData(location);
        if (weatherData != null) {
            weatherCache.store(location, weatherData);
            System.out.println("Data fetched from OpenWeather API for location: " + location);
        }
        return weatherData;
    }
    
    
}

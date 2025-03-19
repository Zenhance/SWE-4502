package utils;

import datamodels.WeatherCacheEntry;
import datamodels.WeatherData;

import java.util.concurrent.ConcurrentHashMap;

public class WeatherCacheManager {
    private final ConcurrentHashMap<String, WeatherCacheEntry> cache;

    public WeatherCacheManager() {
        this.cache = new ConcurrentHashMap<>();
    }

    public WeatherData get(String key)
    {
        WeatherCacheEntry entry = cache.get(key);
        if(entry != null && !entry.isExpired())
        {
            return entry.getWeatherData();
        }
        if(entry != null)
        {
            cache.remove(key);
        }
        return null;
    }
    public void put(String key,WeatherData weatherdata)
    {
        cache.put(key,new WeatherCacheEntry(weatherdata));
    }
    private String generateKey(String city) {
        return "city:" + city.toLowerCase();
    }

    private String generateKey(double latitude, double longitude) {
        return String.format("coord:%.4f:%.4f", latitude, longitude);
    }
    public WeatherData getByCity(String city) {
        return get(generateKey(city));
    }

    public WeatherData getByCoordinates(double latitude, double longitude) {
        return get(generateKey(latitude, longitude));
    }

    public void putByCity(String city, WeatherData weatherData) {
        put(generateKey(city), weatherData);
    }

    public void putByCoordinates(double latitude, double longitude, WeatherData weatherData) {
        put(generateKey(latitude, longitude), weatherData);
    }
}

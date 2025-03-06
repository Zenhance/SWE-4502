package Proxy;

import Adapters.OpenWeatherAdapter;
import Adapters.WeatherStackAdapter;
import Cache.CachedWeatherData;
import Models.WeatherData;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class WeatherProxy {
    private final OpenWeatherAdapter openWeather;
    private final WeatherStackAdapter weatherStack;
    private final Map<String, CachedWeatherData> cache;
    private final Map<String, LocalDateTime> rateLimit;

    public WeatherProxy() {
        this.openWeather = new OpenWeatherAdapter();
        this.weatherStack = new WeatherStackAdapter();
        this.cache = new HashMap<>();
        this.rateLimit = new HashMap<>();
    }

    public WeatherData getWeather(String city, double latitude, double longitude) {
        String cacheKey = city.toLowerCase();
        LocalDateTime now = LocalDateTime.now();

        // Check cache
        if (cache.containsKey(cacheKey)) {
            CachedWeatherData cachedData = cache.get(cacheKey);
            if (cachedData.isValid()) {
                return cachedData.getData();
            }
        }

        // Check rate limit
        if (rateLimit.containsKey("OpenWeather") && rateLimit.get("OpenWeather").plusSeconds(30).isAfter(now)) {
            System.out.println("Rate limit reached for OpenWeather. Switching to WeatherStack...");
            return fetchFromWeatherStack(city, latitude, longitude, cacheKey);
        }

        // Fetch from OpenWeather
        WeatherData weatherData = openWeather.getWeather(city, latitude, longitude);
        if (weatherData != null) {
            cache.put(cacheKey, new CachedWeatherData(weatherData));
            rateLimit.put("OpenWeather", now);
            return weatherData;
        }

        // Fallback to WeatherStack
        return fetchFromWeatherStack(city, latitude, longitude, cacheKey);
    }

    private WeatherData fetchFromWeatherStack(String city, double latitude, double longitude, String cacheKey) {
        WeatherData weatherData = weatherStack.getWeather(city, latitude, longitude);
        if (weatherData != null) {
            cache.put(cacheKey, new CachedWeatherData(weatherData));
            rateLimit.put("WeatherStack", LocalDateTime.now());
        }
        return weatherData;
    }

    private static class CachedWeatherData {
        private final WeatherData data;
        private final LocalDateTime timestamp;

        public CachedWeatherData(WeatherData data) {
            this.data = data;
            this.timestamp = LocalDateTime.now();
        }

        public boolean isValid() {
            return timestamp.plusMinutes(10).isAfter(LocalDateTime.now());
        }

        public WeatherData getData() {
            return data;
        }
    }
}

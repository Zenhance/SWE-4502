package services;

import adapter.IPAdapter;
import adapter.OpenWeatherAdapter;
import adapter.WeatherStackAdapter;
import models.Location;
import models.WeatherData;
import utils.CacheManager;

import java.util.HashMap;

public class WeatherServiceProxy {
    private final WeatherStackAdapter weatherStack;
    private final OpenWeatherAdapter openWeather;
    private final IPAdapter ipAdapter;
    private final CacheManager cacheManager;

    private final HashMap<String, Long> rateLimiter;

    public WeatherServiceProxy() {
        this.weatherStack = new WeatherStackAdapter();
        this.openWeather = new OpenWeatherAdapter();
        this.ipAdapter = new IPAdapter();
        this.cacheManager = new CacheManager();
        this.rateLimiter = new HashMap<>();
    }

    public WeatherData getWeatherByIP() throws Exception {
        Location location = ipAdapter.getLocationByIP(); // Fetch location by IP
        return getWeatherFromProvidersByIP(location.getLatitude(), location.getLongitude());
    }

    public WeatherData getWeatherByCity(String city) throws Exception {
        // Check cache first
        WeatherData cachedData = cacheManager.getCachedData(city);
        if (cachedData != null) {
            System.out.println("Serving from cache for city: " + city);
            return cachedData;
        }

        // Attempt to fetch data from WeatherStack first
        try {
            if (isRateAllowed("WeatherStack")) {
                System.out.println("Fetching data from WeatherStack for city: " + city);
                WeatherData weatherData = weatherStack.getWeatherByCity(city);
                cacheManager.cacheData(city, weatherData);
                updateRateLimiter("WeatherStack");
                return weatherData;
            } else {
                System.out.println("WeatherStack rate limit active, trying OpenWeather...");
            }
        } catch (Exception e) {
            System.out.println("WeatherStack failed: " + e.getMessage());
        }

        // Fallback to OpenWeather if WeatherStack fails
        try {
            System.out.println("Fetching data from OpenWeather for city: " + city);
            WeatherData weatherData = openWeather.getWeatherByCity(city);
            cacheManager.cacheData(city, weatherData);
            return weatherData;
        } catch (Exception e) {
            System.out.println("OpenWeather failed: " + e.getMessage());
            throw new Exception("All providers failed for city: " + city);
        }
    }

    private WeatherData getWeatherFromProvidersByIP(double latitude, double longitude) throws Exception {
        String cacheKey = "IP:" + latitude + "," + longitude;
        // Check cache
        WeatherData cachedData = cacheManager.getCachedData(cacheKey);
        if (cachedData != null) {
            System.out.println("Serving from cache for IP-based location.");
            return cachedData;
        }

        // Attempt to fetch data from WeatherStack first
        try {
            if (isRateAllowed("WeatherStack")) {
                System.out.println("Fetching data from WeatherStack for IP-based location.");
                WeatherData weatherData = weatherStack.getWeatherByIP(latitude, longitude);
                cacheManager.cacheData(cacheKey, weatherData);
                updateRateLimiter("WeatherStack");
                return weatherData;
            } else {
                System.out.println("WeatherStack rate limit active, trying OpenWeather...");
            }
        } catch (Exception e) {
            System.out.println("WeatherStack failed: " + e.getMessage());
        }

        // Fallback to OpenWeather if WeatherStack fails
        try {
            System.out.println("Fetching data from OpenWeather for IP-based location.");
            WeatherData weatherData = openWeather.getWeatherByIP(latitude, longitude);
            cacheManager.cacheData(cacheKey, weatherData);
            return weatherData;
        } catch (Exception e) {
            System.out.println("OpenWeather failed: " + e.getMessage());
            throw new Exception("All providers failed for IP-based location.");
        }
    }

    private boolean isRateAllowed(String provider) {
        long currentTime = System.currentTimeMillis();
        Long lastRequestTime = rateLimiter.get(provider);

        return lastRequestTime == null || (currentTime - lastRequestTime > 30000); // 30-second cooldown
    }

    private void updateRateLimiter(String provider) {
        rateLimiter.put(provider, System.currentTimeMillis());
    }
}

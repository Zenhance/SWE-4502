package Service;

import Model.Location;
import Model.Weather;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;

public class ProxyWeatherService {
    private final RealWeatherService realWeatherService;
    private final ConcurrentHashMap<String, Weather> cache;
    private final ConcurrentHashMap<String, LocalDateTime> cacheTimestamps;

    public ProxyWeatherService() {
        this.realWeatherService = new RealWeatherService();
        this.cache = new ConcurrentHashMap<>();
        this.cacheTimestamps = new ConcurrentHashMap<>();

    }

    @Override
    public Weather getWeather(Location location) throws IOException {
        String key = location.getCity().toLowerCase();

        if (cache.containsKey(key) && !isCacheExpired(key)) {
            System.out.println("Fetching weather data for " + location.getCity() + " from cache");
            return cache.get(key);
        }
        Weather weather = realWeatherService.getWeather(location);
        cache.put(key, weather);
        cacheTimestamps.put(key, LocalDateTime.now());
        return weather;
    }
    private boolean isCacheExpired(String key) {


    }
    }


}

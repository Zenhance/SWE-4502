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

}

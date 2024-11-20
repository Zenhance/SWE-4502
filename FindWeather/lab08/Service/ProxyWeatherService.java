package Service;

public class ProxyWeatherService {
    private final RealWeatherService realWeatherService;
    private final ConcurrentHashMap<String, Weather> cache;
    private final ConcurrentHashMap<String, LocalDateTime> cacheTimestamps;

}

package Utils;

import java.time.Instant;
import java.util.HashMap;
import Models.WeatherData;

public class WeatherCache {
    private static WeatherCache instance;

    private WeatherCache(){}

    public static WeatherCache getInstance() {
        if (instance == null) {
            instance = new WeatherCache();
        }
        return instance;
    }

    private static final long CACHE_DURATION = 10 * 60; // 600 seconds
    private final HashMap<String, CacheEntry> cache = new HashMap<>();

    private  class CacheEntry {
        WeatherData data;
        Instant timestamp;

        CacheEntry(WeatherData data, Instant timestamp) {
            this.data = data;
            this.timestamp = timestamp;
        }
    }

    public void store(String location, WeatherData data) {
        cache.put(location, new CacheEntry(data, Instant.now()));
    }

    public WeatherData retrieve(String location) {
        if (cache.containsKey(location)) {
            CacheEntry entry = cache.get(location);
            if (Instant.now().getEpochSecond() - entry.timestamp.getEpochSecond() < CACHE_DURATION) {
                return entry.data;
            } else {
                // remove if time exceeded => expired
                cache.remove(location);
            }
        }
        return null;
    }

    public boolean isInCache(String location) {
        return retrieve(location) != null;
    }
}

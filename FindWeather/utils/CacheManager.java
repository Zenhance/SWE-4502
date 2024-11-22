package utils;

import models.WeatherData;

import java.util.HashMap;

public class CacheManager {
    private final HashMap<String, CacheEntry> cache = new HashMap<>();
    public WeatherData getCachedData(String location) {
        CacheEntry entry = cache.get(location);
        if (entry != null && (System.currentTimeMillis() - entry.timestamp < 600000)) {
            return entry.data;
        }
        return null;
    }
    public void cacheData(String location, WeatherData data) {
        cache.put(location, new CacheEntry(data));
    }
    private static class CacheEntry {
        WeatherData data;
        long timestamp;
        CacheEntry(WeatherData data) {
            this.data = data;
            this.timestamp = System.currentTimeMillis();
        }
    }
}

package Utils;

import java.time.Instant;
import java.util.HashMap;
import Models.WeatherData;

public class WeatherCache {
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
}

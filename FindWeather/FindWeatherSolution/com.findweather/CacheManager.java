package com.findweather;

import com.findweather.models.WeatherData;
import java.util.HashMap;

public class CacheManager {
    private static final HashMap<String, WeatherData> cache = new HashMap<>();
    private static final long CACHE_DURATION = 10 * 60 * 1000; // 10 minutes

    public static void saveWeatherToCache(String location, WeatherData data) {
        data.setTimestamp(System.currentTimeMillis());
        cache.put(location, data);
    }

    public static WeatherData getWeatherFromCache(String location) {
        if (cache.containsKey(location)) {
            WeatherData data = cache.get(location);
            if (System.currentTimeMillis() - data.getTimestamp() < CACHE_DURATION) {
                return data;
            }
            cache.remove(location);
        }
        return null;
    }
}

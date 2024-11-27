package Cache;

import Models.WeatherData;

import java.time.LocalDateTime;

public class CachedWeatherData {
    private static WeatherData data;
    private static LocalDateTime timestamp;

    // Private constructor to prevent instantiation
    private CachedWeatherData() {}

    // Static method to set the cached data
    public static void setCache(WeatherData newData) {
        data = newData;
        timestamp = LocalDateTime.now();
    }

    // Static method to check if the cache is still valid
    public static boolean isValid() {
        return timestamp != null && timestamp.plusMinutes(10).isAfter(LocalDateTime.now());
    }

    // Static method to get the cached data
    public static WeatherData getData() {
        if (isValid()) {
            return data;
        }
        return null; // Return null if the cache is invalid
    }
}

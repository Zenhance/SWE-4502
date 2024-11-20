package Utils;

import java.util.HashMap;
import Models.WeatherData;

public class WeatherCache {
    private static final long CACHE_DURATION = 10 * 60; // 600 seconds
    private final HashMap<String, WeatherData> cache = new HashMap<>();
}

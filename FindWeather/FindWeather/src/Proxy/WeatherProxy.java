package Proxy;

import Adapters.OpenWeatherAdapter;
import Adapters.WeatherStackAdapter;
import Cache.CachedWeatherData;
import Models.WeatherData;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class WeatherProxy {
    private final OpenWeatherAdapter openWeather;
    private final WeatherStackAdapter weatherStack;

    private final Map<String, CachedWeatherData> cache;

    private final Map<String, LocalDateTime> rateLimit;

    public WeatherProxy(){
        openWeather = new OpenWeatherAdapter();
        weatherStack = new WeatherStackAdapter();
        cache = new HashMap<>();
        rateLimit = new HashMap<>();

    }

    public WeatherData getWeather(String city, double latitude, double longitude){
        String cacheKey=city.toLowerCase();
        LocalDateTime now = LocalDateTime.now();

        if (cache.containsKey(cacheKey)){
            CachedWeatherData cachedData=cache.get(cacheKey);
            if (cachedData.isValid()){
                return cachedData.getData();
            }
        }

        
    }






}

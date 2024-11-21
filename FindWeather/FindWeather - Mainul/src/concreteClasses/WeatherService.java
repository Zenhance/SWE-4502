package concreteClasses;
import java.util.*;

import APIs.WeatherStackAPI;
import adapters.OpenWeatherAdapter;
import adapters.WeatherStackAdapter;
import concreteClasses.utility.TimeManager;

import java.util.HashMap;

public class WeatherService {
    private WeatherStackAdapter weatherStack;
    private OpenWeatherAdapter openWeather;
    private Dictionary<String, WeatherData> cache;

    public WeatherService(){
        weatherStack = new WeatherStackAdapter();
        openWeather = new OpenWeatherAdapter();
        cache = new Hashtable<>();
    }
    private boolean isCacheExpired(String location){
        TimeManager timeManager = new TimeManager();
        return timeManager.isTimeWithinLast10Minutes(cache.get(location).getTime());
    }

}

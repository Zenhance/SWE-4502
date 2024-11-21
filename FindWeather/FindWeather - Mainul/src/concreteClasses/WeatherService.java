package concreteClasses;
import java.util.*;

import APIs.WeatherStackAPI;
import adapters.OpenWeatherAdapter;
import adapters.WeatherStackAdapter;

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


}

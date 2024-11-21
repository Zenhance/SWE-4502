package concreteClasses;

import APIs.WeatherStackAPI;
import adapters.OpenWeatherAdapter;
import adapters.WeatherStackAdapter;

import java.util.Dictionary;
import java.util.HashMap;

public class WeatherService {
    private WeatherStackAdapter weatherStack;
    private OpenWeatherAdapter openWeather;
    private Map<String, WeatherData> cache = new HashMap<>();


    public WeatherService(){
        weatherStack = new WeatherStackAdapter();
        openWeather = new OpenWeatherAdapter();

    }


}

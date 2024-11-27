package concreteClasses;
import java.util.*;

import adapters.OpenWeatherAdapter;
import adapters.WeatherStackAdapter;
import concreteClasses.utility.TimeManager;

public class WeatherService {
    private WeatherStackAdapter weatherStack;
    private OpenWeatherAdapter openWeather;
    private Dictionary<String, WeatherData> cache;
    private boolean flag;
    public WeatherService(){
        weatherStack = new WeatherStackAdapter();
        openWeather = new OpenWeatherAdapter();
        cache = new Hashtable<>();
        flag = true;
    }
    private boolean isCacheExpired(String location, String dataSource){
        TimeManager timeManager = new TimeManager();
        return timeManager.isTimeWithinLast10Minutes(cache.get(location).getTime());
    }

    public void printWeatherData(String location){
        WeatherData weatherData = cache.get(location);
        if(weatherData == null || isCacheExpired(location, weatherData.getDataSource()))  {
            cache.remove(location);
            if(flag) {
                weatherData = weatherStack.getWeatherData(location);
            }
            else {
                weatherData = openWeather.getWeatherData(location);
            }
            flag = !flag;
            System.out.println(location);
            cache.put(location, weatherData);

        }
        weatherData.printWeatherData();
    }
}

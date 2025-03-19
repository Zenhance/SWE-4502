package proxyservice;

import behaviours.IWeatherService;
import datamodels.LocationData;
import datamodels.WeatherCacheEntry;
import datamodels.WeatherData;
import serviceadapters.LocationServiceAdapter;
import utils.WeatherCacheManager;
import utils.WeatherServiceProviderManager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WeatherServiceProxy implements IWeatherService {
    private final WeatherServiceProviderManager serviceProviderManager;
    private final WeatherCacheManager cacheManager;

    public WeatherServiceProxy()
    {
        this.serviceProviderManager=new WeatherServiceProviderManager();
        this.cacheManager=new WeatherCacheManager();
    }

    @Override
    public WeatherData getWeatherDataByCity(String city) throws Exception {
        WeatherData weatherData=cacheManager.getByCity(city);
        if(weatherData!=null)
        {
            return weatherData;
        }

        IWeatherService serviceProvider=serviceProviderManager.getAvailableProvider();
        weatherData=serviceProvider.getWeatherDataByCity(city);
        cacheManager.putByCity(city,weatherData);
        return weatherData;

    }

    @Override
    public WeatherData getWeatherDataByIP() throws Exception {
        LocationServiceAdapter location = new LocationServiceAdapter();

        double latitude = location.getLocationData().getLatitude();
        double longitude = location.getLocationData().getLongitude();

        WeatherData weatherData=cacheManager.getByCoordinates(latitude,longitude);
        if(weatherData!=null)
        {
            return weatherData;
        }
        try{
            IWeatherService serviceProvider=serviceProviderManager.getAvailableProvider();
            weatherData=serviceProvider.getWeatherDataByIP();
            cacheManager.putByCoordinates(latitude,longitude,weatherData);
            return weatherData;

        }catch(Exception e){
            throw new Exception("Too many requests. Please try again later after some time");
        }

    }
}

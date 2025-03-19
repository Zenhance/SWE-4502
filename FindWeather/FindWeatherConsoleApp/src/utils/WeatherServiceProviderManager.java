package utils;

import behaviours.IWeatherService;
import serviceadapters.OpenWeatherAdapter;
import serviceadapters.WeatherStackAdapter;

import java.util.ArrayList;
import java.util.List;

public class WeatherServiceProviderManager {
    private final List<IWeatherService> WeatherServiceProvider;
    private final RateLimiter rateLimiter;
    public WeatherServiceProviderManager()
    {
        WeatherServiceProvider=new ArrayList<>();
        this.rateLimiter=new RateLimiter();
        WeatherServiceProvider.add(new OpenWeatherAdapter());
        WeatherServiceProvider.add(new WeatherStackAdapter());
    }

    public IWeatherService getAvailableProvider(){
        for(IWeatherService provider : WeatherServiceProvider)
        {
            String providerName = provider.getClass().getSimpleName();
            if(rateLimiter.canMakeRequest(providerName))
            {
                rateLimiter.recordRequest(providerName);
                return provider;
            }
        }
        return null;
    }

}

using WeatherAPP.ApiAdapters;
using WeatherAPP.ApiAdapters.WeatherAPIs;
using WeatherAPP.Factory;
using WeatherAPP.Model;
using WeatherAPP.Service;

namespace WeatherAPP.Proxy;

public class WeatherProxy
{
    public string _Ip;
    private Location _location;
    
    public WeatherProxy()
    {
        _Ip = new IpapiAdapter().Getip();
        _location = new LocationProxy(_Ip).GetLocation();
    }
    
    private Wether FetchWeather()
    {
        if (new IsWeatherAvailableService().Execute(_location))
        {
            Wether wether = new FetchWetherFromFileService().Execute(_location);
            return wether;
        }
        else
        {
            IWeatherAdapter weatherAdapter = new WetherFactory().GetWeatherAdapter(_location);
            
        }
        
    }
    
}
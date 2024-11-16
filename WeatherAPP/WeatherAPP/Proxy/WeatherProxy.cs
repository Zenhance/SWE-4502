using WeatherAPP.ApiAdapters;
using WeatherAPP.Model;

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
    
    // private Wether FetchWeather()
    // {
    //     
    // }
    
}
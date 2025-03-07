using WeatherAPP.ApiAdapters.WeatherAPIs;
using WeatherAPP.Model;

namespace WeatherAPP.Factory;

public class WetherFactory
{
    public IWeatherAdapter GetWeatherAdapter(Location location)
    {
        if (location.City == null)
        {
            return new OpenWetherApiAdapter(location.Latitude, location.Longitude);
        }
        return new WeatherStackAPIAdapter(location.City);
    }
}
using WeatherAPP.Model;

namespace WeatherAPP.ApiAdapters.WeatherAPIs;

public interface IWeatherAdapter
{
    public Wether GetWeather();
}
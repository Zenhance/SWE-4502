using FindWeather.Location;

namespace FindWeather.Weather;

public class WeatherApiFacade
{
    private readonly ILocationApi _locationApi;
    private readonly IWeatherAPI _weatherProxy;

    public WeatherApiFacade(ILocationApi locationApi, IWeatherAPI weatherProxy)
    {
        _locationApi = locationApi;
        _weatherProxy = weatherProxy;
    }

    public async Task ShowWeatherByIp()
    {
        var (latitude, longitude, city) = await _locationApi.GetLocation();
        DisplayWeather(city, latitude, longitude);
    }

    public async Task ShowWeatherByCity()
    {
         var (latitude, longitude, city) = await _locationApi.GetLocation();
        DisplayWeather(city, latitude, longitude);
    }

    private void DisplayWeather(string city, double latitude, double longitude)
    {
        var weather = _weatherProxy.GetWeatherData(latitude, longitude);
        Console.WriteLine($"Weather in {city} from {weather.Source}: {weather.Temperature}°C, {weather.Conditions}");
    }
}

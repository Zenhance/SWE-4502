namespace WeatherAPP.ApiAdapters.WeatherAPIs;

public class WeatherStackAPIAdapter : IWeatherAdapter
{
    private string _city;

    public WeatherStackAPIAdapter(string city)
    {
        _city = city;
    }
    
    public string GetWeather()
    {
        
    }
}
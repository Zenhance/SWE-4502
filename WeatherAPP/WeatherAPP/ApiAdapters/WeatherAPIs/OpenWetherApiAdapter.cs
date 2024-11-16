namespace WeatherAPP.ApiAdapters.WeatherAPIs;

public class OpenWetherApiAdapter : IWeatherAdapter
{
    private double _latitude { get; set; }
    private double _longitude{get; set;}
    
    public OpenWetherApiAdapter(double latitude, double longitude)
    {
        _latitude = latitude;
        _longitude = longitude;
    }

    public string GetWeather()
    {
        return "";
    }
}
using FindWeather.Data;

namespace FindWeather.Weather;

public interface IWeatherAPI
{
    WeatherData GetWeatherData(double latitude, double longitude);
}
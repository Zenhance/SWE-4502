
using System.Text.Json;
using FindWeather.Data;

namespace FindWeather.Weather;

public class OpenWeatherAdapter : IWeatherAPI
{
    private readonly HttpClient _httpClient;
    private const string ApiKey = "651e53e11cbd951c0d4f5b541422ee1a";
    private const string Unit = "metric";

    public OpenWeatherAdapter()
    {
        _httpClient = new HttpClient();
    }

    public WeatherData GetWeatherData(double latitude, double longitude)
    {
        var query = _httpClient.GetStringAsync(
            $"https://api.openweathermap.org/data/2.5/weather?lat={latitude}&lon={longitude}&units={Unit}&appid={ApiKey}"
        );
        
        var response = query.Result;

        using (JsonDocument jsonDoc = JsonDocument.Parse(response))
        {
            var temp = jsonDoc.RootElement.GetProperty("main").GetProperty("temp").GetDouble();
            var conditions = jsonDoc.RootElement.GetProperty("weather")[0].GetProperty("description").GetString()!;
            var location = $"Lat: {latitude}, Lon: {longitude}";

            // Return the essential data in a WeatherData object
            return new WeatherData
            {
                Location = location,
                Temperature = temp,
                Conditions = conditions
            };
        }
    }
}
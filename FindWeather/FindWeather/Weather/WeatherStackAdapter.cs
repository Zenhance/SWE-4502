using System.Text.Json;
using FindWeather.Data;

namespace FindWeather.Weather;

public class WeatherStackAdapter : IWeatherAPI
{
    private readonly HttpClient _httpClient;
    private const string ApiKey = "462e316b52668a55c98e4a666087aba5";

    public WeatherStackAdapter()
    {
        _httpClient = new HttpClient();
    }

    public WeatherData GetWeatherData(double latitude, double longitude)
    {
        var response = _httpClient.GetStringAsync(
            $"http://api.weatherstack.com/current?access_key={ApiKey}&query={latitude},{longitude}"
        ).Result;

        using (var jsonDoc = JsonDocument.Parse(response))
        {
            var location = jsonDoc.RootElement.GetProperty("location").GetProperty("name").GetString()!;
            var temperature = jsonDoc.RootElement.GetProperty("current").GetProperty("temperature").GetDouble()!;
            var conditions = jsonDoc.RootElement.GetProperty("current").GetProperty("weather_descriptions")[0].GetString()!;

            return new WeatherData
            {
                Location = location,
                Temperature = temperature,
                Conditions = conditions
            };
        }
    }
}

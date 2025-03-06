using FindWeatherMySolution.config;
using FindWeatherMySolution.interfaces;
using FindWeatherMySolution.models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;

namespace FindWeatherMySolution.adopters
{
    public class WeatherStackAdapter : IWeatherProvider
    {
        private readonly HttpClient _httpClient;
        private readonly ApiKey _apiKey;

        public string Name => "WeatherStack";
        public DateTime LastRequestTime { get; set; } = DateTime.MinValue;

        public WeatherStackAdapter()
        {
            _httpClient = new HttpClient();
            _apiKey = new ApiKey();
        }

        public async Task<WeatherData> GetWeatherData(Location location)
        {
            try
            {
                var apiKey = _apiKey.GetWeatherStackApiKey();
                string url;

                if (!string.IsNullOrEmpty(location.City))
                {
                    url = $"http://api.weatherstack.com/current?access_key={apiKey}&query={location.City}";
                }
                else
                {
                    url = $"http://api.weatherstack.com/current?access_key={apiKey}&query={location.Latitude},{location.Longitude}";
                }

                var response = await _httpClient.GetStringAsync(url);
                var data = JsonSerializer.Deserialize<JsonElement>(response);

                var cityName = data.GetProperty("location").GetProperty("name").GetString();
                var temperature = data.GetProperty("current").GetProperty("temperature").GetDouble();
                var conditions = data.GetProperty("current").GetProperty("weather_descriptions")[0].GetString();

                return new WeatherData
                {
                    Location = new Location { City = cityName },
                    Temperature = temperature,
                    Conditions = conditions,
                    Source = Name,
                    Timestamp = DateTime.Now
                };
            }
            catch (Exception ex)
            {
                throw new Exception($"WeatherStack API error: {ex.Message}", ex);
            }
        }
    }
}

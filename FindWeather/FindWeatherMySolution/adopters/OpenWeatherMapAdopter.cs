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
    public class OpenWeatherMapAdapter : IWeatherProvider
    {
        private readonly HttpClient _httpClient;
        private readonly ApiKey _apiKey;

        public string Name => "OpenWeatherMap";
        public DateTime LastRequestTime { get; set; } = DateTime.MinValue;

        public OpenWeatherMapAdapter()
        {
            _httpClient = new HttpClient();
            _apiKey = new ApiKey();
        }

        public async Task<WeatherData> GetWeatherData(Location location)
        {
            try
            {
                var apiKey = _apiKey.GetOpenWeatherMapApiKey();
                string url;

                if (!string.IsNullOrEmpty(location.City))
                {
                    url = $"https://api.openweathermap.org/data/2.5/weather?q={location.City}&appid={apiKey}&units=metric";
                }
                else
                {
                    url = $"https://api.openweathermap.org/data/2.5/weather?lat={location.Latitude}&lon={location.Longitude}&appid={apiKey}&units=metric";
                }

                var response = await _httpClient.GetStringAsync(url);
                var data = JsonSerializer.Deserialize<JsonElement>(response);

                var cityName = data.GetProperty("name").GetString();
                var temperature = data.GetProperty("main").GetProperty("temp").GetDouble();
                var conditions = data.GetProperty("weather")[0].GetProperty("main").GetString();

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
                throw new Exception($"OpenWeatherMap API error: {ex.Message}", ex);
            }
        }
    }
}

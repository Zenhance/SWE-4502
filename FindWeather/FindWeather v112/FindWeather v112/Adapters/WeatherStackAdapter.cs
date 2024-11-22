using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;

namespace FindWeather_v112
{
    internal class WeatherStackAdapter:IWeatherProvider
    {
        public WeatherStackAPI baseClient = new WeatherStackAPI();
        public async Task<WeatherData> GetWeatherByCityAsync(string city)
        {
            throw new NotImplementedException("This adapter does not support city-based lookups.");
        }
        public async Task<WeatherData> GetWeatherAsync(double latitude, double longitude)
        {
            var response = await baseClient.FetchWeatherData(latitude, longitude);
            var json = JsonDocument.Parse(response);
            return new WeatherData
            {
                City = json.RootElement.GetProperty("location").GetProperty("name").GetString(),
                Temperature = json.RootElement.GetProperty("current").GetProperty("temperature").GetDouble(),
                Condition = json.RootElement.GetProperty("current").GetProperty("weather_descriptions")[0].GetString(),
                Source = "WeatherStack"
            };
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;

namespace FindWeather_v112
{
    internal class OpenWeatherAdapter:IWeatherProvider
    {
        public OpenWeatherAPI baseClient = new OpenWeatherAPI();
        public async Task<WeatherData> GetWeatherAsync(double latitude, double longitude)
        {
            var response = await baseClient.FetchWeatherDataByCoordinates(latitude, longitude);
            var json = JsonDocument.Parse(response);
            return new WeatherData
            {
                City = json.RootElement.GetProperty("name").GetString(),
                Temperature = json.RootElement.GetProperty("main").GetProperty("temp").GetDouble(),
                Condition = json.RootElement.GetProperty("weather")[0].GetProperty("description").GetString(),
                Source = "OpenWeatherMap"
            };
        }
        public async Task<WeatherData> GetWeatherByCityAsync(string city)
        {
            var response = await baseClient.FetchWeatherDataByCity(city);
            var json = JsonDocument.Parse(response);
            return new WeatherData//same ase the previous one!
            {
                City = json.RootElement.GetProperty("name").GetString(),
                Temperature = json.RootElement.GetProperty("main").GetProperty("temp").GetDouble(),
                Condition = json.RootElement.GetProperty("weather")[0].GetProperty("description").GetString(),
                Source = "OpenWeatherMap"
            };
        }

    }
}

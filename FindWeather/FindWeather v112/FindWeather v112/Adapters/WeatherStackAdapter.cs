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
        }
    }
}

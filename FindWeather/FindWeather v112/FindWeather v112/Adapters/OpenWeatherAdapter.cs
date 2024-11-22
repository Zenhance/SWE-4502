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
        }

    }
}

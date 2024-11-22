using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
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
    }
}

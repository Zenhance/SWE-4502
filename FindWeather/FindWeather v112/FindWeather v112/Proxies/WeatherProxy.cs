using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FindWeather_v112
{
    internal class WeatherProxy:IWeatherProvider
    {
        public IWeatherProvider provider;
        public Dictionary<string, (WeatherData, DateTime)> cache = new Dictionary<string, (WeatherData, DateTime)>();
        public DateTime lastRequestTime = DateTime.MinValue;

    }
}

using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_8_FindWeather
{
    public class RealWeatherService : IWeatherService
    {
        private static bool useWeatherStack = true;
        private static DateTime lastApiCallTime;

        public Weather GetWeather(Location location)
        {
            if (lastApiCallTime != default && (DateTime.Now - lastApiCallTime).TotalSeconds < 5)
            {
                useWeatherStack = !useWeatherStack;
            }

            lastApiCallTime = DateTime.Now;

            if (useWeatherStack)
            {
                return WeatherStackAPI.Get_Weather(location);
            }
            else
            {
                return OpenWeatherAPI.Get_Weather(location);
            }
        }
    }
}

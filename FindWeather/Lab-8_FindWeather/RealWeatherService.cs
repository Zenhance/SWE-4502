using System;
using System.Collections.Generic;
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
            // Check if the last API call was less than 30 seconds ago
            if (lastApiCallTime != default && (DateTime.Now - lastApiCallTime).TotalSeconds < 30)
            {
                useWeatherStack = !useWeatherStack; // Toggle the API
            }

            // Update the last API call time
            lastApiCallTime = DateTime.Now;

            // Use WeatherStackAPI or OpenWeatherAPI based on the toggle
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

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FindWeather_v112
{
    internal class WeatherFacade
    {
        public WeatherProxy weatherStackProxy;
        public WeatherProxy openWeatherProxy;
        public (double Latitude, double Longitude)? cachedLocation = null;
    }
}

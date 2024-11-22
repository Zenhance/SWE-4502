using FindWeather_v112;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FindWeather_v112
{
    internal interface IWeatherProvider
    {
        Task<WeatherData> GetWeatherAsync(double latitude, double longitude);
        Task<WeatherData> GetWeatherByCityAsync(string city);
    }
}

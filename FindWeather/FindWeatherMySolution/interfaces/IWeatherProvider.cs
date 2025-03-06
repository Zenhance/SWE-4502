using FindWeatherMySolution.models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FindWeatherMySolution.interfaces
{
    public interface IWeatherProvider
    {
        string Name { get; }
        Task<WeatherData> GetWeatherData(Location location);
        DateTime LastRequestTime { get; set; }
    }
}

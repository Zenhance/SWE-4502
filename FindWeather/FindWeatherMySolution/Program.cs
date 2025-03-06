using FindWeatherMySolution.services;
using FindWeatherMySolution.models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using FindWeatherMySolution.adopters;

namespace FindWeatherMySolution
{
    internal class Program
    {
        static async Task Main(string[] args)
        {
            LocationService locationService = new LocationService();
            Location location = await locationService.GetLocationByIp();
            location.ShowDetails();

            OpenWeatherMapAdapter adapter = new OpenWeatherMapAdapter();
            var weatherData = await adapter.GetWeatherData(location);
            weatherData.Location = location;

            Console.ReadKey();
        }
    }
}

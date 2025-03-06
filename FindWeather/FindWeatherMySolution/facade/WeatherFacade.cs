using FindWeatherMySolution.adopters;
using FindWeatherMySolution.interfaces;
using FindWeatherMySolution.models;
using FindWeatherMySolution.services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FindWeatherMySolution.facade
{
    public class WeatherFacade
    {
        private readonly ILocationService _locationService;
        private readonly IWeatherService _weatherService;

        public WeatherFacade()
        {
            _locationService = new LocationService();
            _weatherService = new WeatherService(
                new List<IWeatherProvider>
                {
                    new OpenWeatherMapAdapter(),
                    new WeatherStackAdapter()
                }
            );
        }

        public async Task GetWeatherByIp()
        {
            Console.WriteLine("Getting weather data by IP...");

            try
            {
                var location = await _locationService.GetLocationByIp();
                if (location != null)
                {
                    var weatherData = await _weatherService.GetWeather(location);
                    DisplayWeatherData(weatherData);
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error: {ex.Message}");
            }
        }

        public async Task GetWeatherByCity(string cityName)
        {
            Console.WriteLine($"Getting weather data for {cityName}...");

            try
            {
                var location = new Location { City = cityName };
                var weatherData = await _weatherService.GetWeather(location);
                DisplayWeatherData(weatherData);
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error: {ex.Message}");
            }
        }

        private void DisplayWeatherData(WeatherData weatherData)
        {
            Console.WriteLine($"Data retrieved from {weatherData.Source}.");
            Console.WriteLine($"Weather in {weatherData.Location.City} from {weatherData.Source}: {weatherData.Temperature}°C, {weatherData.Conditions}");
        }
    }
}

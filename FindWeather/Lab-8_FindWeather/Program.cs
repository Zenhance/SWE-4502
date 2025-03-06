using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_8_FindWeather
{
    class Program
    {
        static async Task Main(string[] args)
        {
            var ipStackApiKey = "your_ipstack_api_key";
            var openWeatherApiKey = "your_openweather_api_key";
            var weatherStackApiKey = "your_weatherstack_api_key";

            var locationService = new LocationService(ipStackApiKey);
            var weatherServiceManager = new WeatherServiceManager(
                new OpenWeatherService(openWeatherApiKey),
                new WeatherStackService(weatherStackApiKey)
            );

            while (true)
            {
                Console.WriteLine("Select location method: 1. By IP, 2. By City, 3. Exit");
                var choice = Console.ReadLine();

                if (choice == "3") break;

                try
                {
                    if (choice == "1")
                    {
                        Console.WriteLine("Getting weather data by IP...");
                        var location = await locationService.GetLocationByIpAsync();
                        var weatherData = await weatherServiceManager.GetWeatherAsync(location.Latitude, location.Longitude);
                        DisplayWeather(weatherData);
                    }
                    else if (choice == "2")
                    {
                        Console.Write("Enter city name: ");
                        var cityName = Console.ReadLine();
                        // Implement city-based location lookup (optional)
                    }
                }
                catch (Exception ex)
                {
                    Console.WriteLine($"Error: {ex.Message}");
                }
            }
        }

        static void DisplayWeather(WeatherData weatherData)
        {
            Console.WriteLine($"Weather in {weatherData.Location} from {weatherData.DataSource}: {weatherData.Temperature}°C, {weatherData.Conditions}");
        }
    }
}

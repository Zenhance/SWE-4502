using System;
using System.Threading.Tasks;

namespace _210042111_Lab08
{
    public class WeatherFacade
    {
        IWeatherService openWeatherMapAdapter;
        IWeatherService weatherStackAdapter;
        WeatherServiceProxy proxyWeatherStack;
        WeatherServiceProxy proxyOpenWeather;

        public WeatherFacade()
        {
            openWeatherMapAdapter = new OpenWeatherMapAdapter();
            weatherStackAdapter = new WeatherStackAdapters();
            proxyOpenWeather = new WeatherServiceProxy(openWeatherMapAdapter);
            proxyWeatherStack = new WeatherServiceProxy(weatherStackAdapter);
        }

        public async Task Start()
        {
            Console.WriteLine("Select weather provider: 1. OpenWeatherMap, 2. WeatherStack");
            string model = Console.ReadLine();
            IWeatherService selectedService;

            if (model == "1")
            {
                selectedService = proxyOpenWeather;
            }
            else if (model == "2")
            {
                selectedService = proxyWeatherStack;
            }
            else
            {
                selectedService = proxyOpenWeather; // default
            }

            try
            {
                string city = null;

                
                if (model == "2")
                {
                    Console.WriteLine("Enter the city name:");
                    city = Console.ReadLine();
                }

                WeatherData weatherData = await selectedService.GetWeather(city);
                Console.WriteLine($"Weather: {weatherData.WeatherCondition}, {weatherData.WeatherTemperature}°C at {weatherData.CityName}");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error: {ex.Message}");
            }
        }
    }
}
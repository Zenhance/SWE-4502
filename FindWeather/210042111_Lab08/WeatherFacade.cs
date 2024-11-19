using lab08_210042111;
using System;
using System.Reflection;
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
            string city;
            Console.WriteLine("Enter the city name:");
            city = Console.ReadLine();
            string city;
            Console.WriteLine("Enter the city name:");
            city = Console.ReadLine();
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
        }

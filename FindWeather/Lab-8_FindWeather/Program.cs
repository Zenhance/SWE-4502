using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_8_FindWeather
{
    public class Program
    {
        public static void Main(string[] args)
        {
            while (true)
            {
                Console.WriteLine("\nSelect location method: 1. By IP, 2. By City, 3. Exit");
                int choice = int.Parse(Console.ReadLine());

                if (choice == 3)
                {
                    break;
                }

                Location location = null;
                if (choice == 1)
                {
                    Console.WriteLine("Sabr karo! Abhi vi banay nehi he!\n");
                }
                else if (choice == 2)
                {
                    Console.Write("Enter city name: ");
                    string city = Console.ReadLine();
                    location = GeoLocation.get_location_by_city(city);
                }

                if (location != null)
                {
                    Console.WriteLine($"City: {location.GetCity()} (Latitude, Longitude) => ({location.GetLatitude()}, {location.GetLongitude()})");

                    IWeatherService weatherService = new ProxyWeatherService();
                    Weather weather = weatherService.GetWeather(location);
                    if (weather != null)
                    {
                        weather.DisplayWeather();
                    }
                    Console.WriteLine("________________________________________________________");
                }
            }
        }
    }
}

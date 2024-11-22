using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FindWeather_v112
{
    internal class Program
    {
        static async Task Main(string[] args)
        {
            var facade = new WeatherFacade();
            Console.WriteLine("Select location method: 1. By IP, 2. By City, 3. Exit");
            int choice = int.Parse(Console.ReadLine());
            try
            {
                switch (choice)
                {
                    case 1: // By IP (WeatherStack)
                        var weatherByIP = await facade.GetWeatherByIP();
                        Console.WriteLine($"Weather in {weatherByIP.City} from {weatherByIP.Source}: {weatherByIP.Temperature}°C, {weatherByIP.Condition}");
                        break;
                    case 2: // By City (OpenWeatherMap)
                        Console.Write("City name: ");
                        string city = Console.ReadLine();
                        if (string.IsNullOrWhiteSpace(city))
                        {
                        }
                        else
                        {
                           
                        }
                        break;
                    case 3: // Exit
                        Console.WriteLine("Exiting...");
                        break;
                    default:
                        Console.WriteLine("Ware there any more choices?Are you dumb?");
                        break;
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error: {ex.Message}");
            }
        }
    }
}

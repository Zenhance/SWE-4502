using FindWeatherMySolution.services;
using FindWeatherMySolution.models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using FindWeatherMySolution.adopters;
using FindWeatherMySolution.facade;

namespace FindWeatherMySolution
{
    internal class Program
    {
        static async Task Main(string[] args)
        {
            var weatherFacade = new WeatherFacade();

            bool exit = false;
            while (!exit)
            {
                Console.WriteLine("Select location method: 1. By IP, 2. By City, 3. Exit");
                var input = Console.ReadLine();

                switch (input)
                {
                    case "1":
                        await weatherFacade.GetWeatherByIp();
                        break;
                    case "2":
                        Console.Write("Enter city name: ");
                        var city = Console.ReadLine();
                        if (!string.IsNullOrWhiteSpace(city))
                        {
                            await weatherFacade.GetWeatherByCity(city);
                        }
                        break;
                    case "3":
                        exit = true;
                        break;
                    default:
                        Console.WriteLine("Invalid option. Please try again.");
                        break;
                }

                Console.WriteLine();
            }
        }
    }
}

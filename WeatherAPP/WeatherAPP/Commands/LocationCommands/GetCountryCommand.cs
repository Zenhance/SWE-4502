using System;
using WeatherAPP.ApiAdapters;
using WeatherAPP.Model;
using WeatherAPP.Proxy;

namespace WeatherAPP.Commands.LocationCommands
{
    public class GetCountryCommand : ICommand
    {
        public void Execute()
        {
            string ip = new IpapiAdapter().Getip();
            Location location = new LocationProxy(ip).GetLocation();

            Console.ForegroundColor = ConsoleColor.Yellow;
            Console.Write("Your Country is: ");

            Console.ForegroundColor = ConsoleColor.Cyan;
            Console.WriteLine(location.CountryName);

            Console.ResetColor();
        }
    }
}
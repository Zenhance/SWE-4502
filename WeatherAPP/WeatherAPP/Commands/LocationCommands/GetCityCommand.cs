using WeatherAPP.ApiAdapters;
using WeatherAPP.Model;
using WeatherAPP.Proxy;

namespace WeatherAPP.Commands.LocationCommands;

public class GetCityCommand : ICommand
{
    public void Execute()
    {
        string ip = new IpapiAdapter().Getip();
        Location location = new LocationProxy(ip).GetLocation();
        Console.WriteLine("Your Current City is : " + location.City);
    }
}
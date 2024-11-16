using WeatherAPP.ApiAdapters;
using WeatherAPP.Model;
using WeatherAPP.Proxy;

namespace WeatherAPP.Commands.LocationCommands;

public class GetExactLocationCommand : ICommand
{
    public void Execute()
    {
        string ip = new IpapiAdapter().Getip();
        Location location = new LocationProxy(ip).GetLocation();
        Console.ForegroundColor = ConsoleColor.Yellow;
        Console.Write("Latitude : ");
        Console.ForegroundColor = ConsoleColor.Cyan;
        Console.WriteLine(location.Latitude);
        
        Console.ForegroundColor = ConsoleColor.Yellow;
        Console.Write("Longitude : ");
        Console.ForegroundColor = ConsoleColor.Cyan;
        Console.WriteLine(location.Longitude);
        Console.ForegroundColor = ConsoleColor.White;
        
    }
}
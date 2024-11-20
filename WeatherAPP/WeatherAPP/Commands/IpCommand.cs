using WeatherAPP.ApiAdapters;

namespace WeatherAPP.Commands;

public class IpCommand : ICommand
{
    public void Execute()
    {
        string Ip = new IpapiAdapter().Getip();
        Console.WriteLine("Your IP is " + Ip);
    }
}
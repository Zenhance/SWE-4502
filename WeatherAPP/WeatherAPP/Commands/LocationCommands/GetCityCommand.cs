using WeatherAPP.ApiAdapters;
using WeatherAPP.Model;
using WeatherAPP.Proxy;

namespace WeatherAPP.Commands.LocationCommands;

public class GetCityCommand : ICommand
{
    public void Execute()
    {
        try
        {
            string ip = new IpapiAdapter().Getip();
            Location location = new LocationProxy(ip).GetLocation();
            if(location.City == null)
            {
                throw new Exception();
            }
            Console.WriteLine("Your Current City is : " + location.City);
        }
        catch
        {
            Console.WriteLine("City is not available right now");
        }
        
    }
}
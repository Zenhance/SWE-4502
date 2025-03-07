using WeatherAPP.Commands;
using WeatherAPP.Commands.LocationCommands;

namespace WeatherAPP.Factory;

public class CommandFactory
{
    public ICommand GetCommand(string[] args)
    {
        if (args.Length == 0)
        {
            Console.WriteLine("Invalid");
        }
        else
        {
            if (args.Length == 1)
            {
                if (args[0] == "ip")
                {
                    return new IpCommand();
                }
                else if(args[0] == "weather")
                {
                    return new WetherCommand();
                }
            }

            if (args.Length == 2)
            {
                if (args[0] == "location")
                {
                    if (args[1] == "city")
                    {
                        return new GetCityCommand();
                    }
                    else if (args[1] == "country")
                    {
                        return new GetCountryCommand();
                    }
                    else if (args[1] == "exact")
                    {
                        return new GetExactLocationCommand();
                    }
                }
                else if (args[0] == "weather")
                {
                    return new CityWeatherCommand(args[1]);
                }
            }
        }

        return null;
    }
}
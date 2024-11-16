﻿using WeatherAPP.Commands;
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
            }

            if (args.Length == 2)
            {
                if (args[0] == "location")
                {
                    if (args[1] == "city")
                    {
                        return new GetCityCommand();
                    }
                }
            }
        }

        return null;
    }
}
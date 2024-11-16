using WeatherAPP.Commands;

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
        }

        return null;
    }
}
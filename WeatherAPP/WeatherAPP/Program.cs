using WeatherAPP.Factory;
using WeatherAPP.Commands;

class Program
{
    public static void Main(string[] args)
    {
        CommandFactory commandFactory = new CommandFactory();
        ICommand command = commandFactory.GetCommand(args);

        try
        {
            command.Execute();
        }
        catch (Exception ex)
        {
            Console.WriteLine("Error: " + ex.Message);
        }
    }
}
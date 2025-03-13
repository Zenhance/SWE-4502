using HomeAutomate.Core;
using HomeAutomate.Executor;
using HomeAutomate.Models;

namespace HomeAutomate.Factory;

public class ExecutorFactory
{
    public static StateChangeExecutor getExecutor(Command command, EnvironmentState environment)
    {
        string cmdStr = command.getCommand();
        if (string.IsNullOrEmpty(cmdStr))
        {
            return null; 
        }

        string[] parts = cmdStr.Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
        if (parts.Length < 3 || parts[1].ToLower() != "value")
        {
            return null;
        }

        if (!float.TryParse(parts[2], out float value))
        {
            return null;
        }

        string commandType = parts[0].ToLower();
        Command parsedCommand = new Command(value);

        switch (commandType)
        {
            case "temperature":
                return new TemperatureStateChangeExecutor(environment, parsedCommand);
            case "ambientlightlevel":
            case "light":
                return new AmbientLightLevelStateChangeExecutor(environment, parsedCommand);
            case "motion":
                return new MotionLevelStateChangeExecutor(environment, parsedCommand);
            case "energy":
                return new EnergyConsumptionStateChangeExecutor(environment, parsedCommand);
            default:
                return null;
        }
    }
}
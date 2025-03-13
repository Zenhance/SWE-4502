using HomeAutomate.Core;
using HomeAutomate.Models;

namespace HomeAutomate.Executor;

public class TemperatureStateChangeExecutor : StateChangeExecutor
{
    public TemperatureStateChangeExecutor(EnvironmentState environmentState, Command command)
    {
        _environment = environmentState;
        _command = command;
    }
    
    public override void execute()
    {
        _environment.SetTemperature(_command);
    }
}
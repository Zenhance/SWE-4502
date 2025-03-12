using HomeAutomation.Core;
using HomeAutomation.Models;

namespace HomeAutomation.Executor;

public class TemperatureStateChangeExecutor: StateChangeExecutor
{
    public TemperatureStateChangeExecutor(EnvironmentState environmentState, Command command)
    {
        this.environmentState = environmentState;
        this._command = command;
    }
    
    public override void execute()
    {
        environmentState.SetTemperature(_command);
    }
}
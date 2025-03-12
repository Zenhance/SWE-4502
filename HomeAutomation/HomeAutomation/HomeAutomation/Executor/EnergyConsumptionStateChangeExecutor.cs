using HomeAutomation.Core;
using HomeAutomation.Models;

namespace HomeAutomation.Executor;

public class EnergyConsumptionStateChangeExecutor: StateChangeExecutor
{
    public EnergyConsumptionStateChangeExecutor(EnvironmentState environmentState, Command command)
    {
        this.environmentState = environmentState;
        this._command = command;
    }
    
    public override void execute()
    {
        environmentState.SetEnergyConsumption(_command);
    }
}
using HomeAutomation.Core;
using HomeAutomation.Models;

namespace HomeAutomation.Executor;

public class AmbientLightLevelStateChangeExecutor : StateChangeExecutor
{
    public AmbientLightLevelStateChangeExecutor(EnvironmentState environmentState, Command command)
    {
        this.environmentState = environmentState;
        this._command = command;
    }
    
    public override void execute()
    {
        environmentState.SetAmbientLightLevel(_command);
    }
}
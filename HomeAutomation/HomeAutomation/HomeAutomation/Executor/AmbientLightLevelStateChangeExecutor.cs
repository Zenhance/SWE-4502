using HomeAutomation.Core;
using HomeAutomation.Model;

namespace HomeAutomation.Executor;

public class AmbientLightLevelStateChangeExecutor : StateChangeExecutor
{
    public AmbientLightLevelStateChangeExecutor(EnvironmentState environmentState, Command command)
    {
        _environment = environmentState;
        _command = command;
    }
    
    public override void execute()
    {
        _environment.SetAmbientLightLevel(_command);
    }
}
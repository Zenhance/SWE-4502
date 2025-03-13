using HomeAutomate.Core;
using HomeAutomate.Models;

namespace HomeAutomate.Executor;

public class MotionLevelStateChangeExecutor : StateChangeExecutor
{
    public MotionLevelStateChangeExecutor(EnvironmentState environmentState, Command command)
    {
        _environment = environmentState;
        _command = command;
    }

    public override void execute()
    {
        _environment.SetMotionLevel(_command);
    }
    
}
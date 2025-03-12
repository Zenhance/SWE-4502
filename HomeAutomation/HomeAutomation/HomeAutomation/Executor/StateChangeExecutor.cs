using HomeAutomation.Core;
using HomeAutomation.Models;

namespace HomeAutomation.Executor;

public abstract class StateChangeExecutor
{
    protected EnvironmentState environmentState;
    protected Command _command;

    public StateChangeExecutor(EnvironmentState environmentState, Command command)
    {
        this.environmentState = environmentState;
        this._command = command;
    }

    public StateChangeExecutor()
    {
        
    }
    
    public abstract void execute();

    public Command getCommand()
    {
        return _command;
    }
}
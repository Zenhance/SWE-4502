using HomeAutomate.Core;
using HomeAutomate.Models;

namespace HomeAutomate.Executor;

public abstract class StateChangeExecutor
{
    protected EnvironmentState _environment;
    protected Command _command;
    
    public StateChangeExecutor(EnvironmentState environment, Command command)
    {
        _environment = environment;
        _command = command;
    }
    
    public StateChangeExecutor() { }
    
    public abstract void execute();
    
    public Command getCommand()
    {
        return _command;
    }
}
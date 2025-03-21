namespace TaskManager.Command;

public class CommandManager
{
    public List<ICommand> _commands;

    public CommandManager()
    {
        _commands = new List<ICommand>();
    }

    public void ExecuteCommand(ICommand command)
    {
        _commands.Add(command);
        command.execute();
    }
    
    public void UndoCommand()
    {
        if (_commands.Count > 0)
        {
            ICommand command = _commands[_commands.Count - 1];
            command.undo();
            _commands.Remove(command);
        }
    }

    public void RedoCommand()
    {
        if (_commands.Count > 0)
        {
            ICommand command = _commands[_commands.Count - 1];
            command.execute();
            _commands.Remove(command);
            _commands.Add(command);
        }
    }
}
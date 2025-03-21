namespace TaskManager.Command;

public class CommandManager
{
    public List<ICommand> commands;
    public List<ICommand> undoneCommands;

    public CommandManager()
    {
        commands = new List<ICommand>();
        undoneCommands = new List<ICommand>();
    }
    
    public void ExecuteCommand(ICommand command)
    {
        commands.Add(command);
        command.execute();
        undoneCommands.Clear();
    }

    public void UndoCommand()
    {
        if (commands.Count > 0)
        {
            ICommand command = commands[commands.Count - 1];
            command.undo();
            commands.Remove(command);
            undoneCommands.Add(command);
        }
    }


    public void RedoCommand()
    {
        if(undoneCommands.Count > 0)
        {
            ICommand command = undoneCommands[undoneCommands.Count - 1];
            command.execute();
            undoneCommands.Remove(command);
            commands.Add(command);
        }
    }


    public int GetCommandCount()
    {
        return commands.Count;
    }
}
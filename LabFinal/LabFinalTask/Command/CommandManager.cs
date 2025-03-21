namespace LabFinalTask.Command;

public class CommandManager
{
    public List<ICommand> commands;

    public CommandManager()
    {
        commands = new List<ICommand>();
    }
    
    public void ExecuteCommand(ICommand command)
    {
        commands.Add(command);
        command.execute();
    }

    public void UndoCommand()
    {
        if (commands.Count > 0)
        {
            ICommand command = commands[commands.Count - 1];
            command.undo();
            commands.Remove(command);
        }
    }
}
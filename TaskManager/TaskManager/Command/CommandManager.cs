namespace TaskManagerOriginal.Command;

public class CommandManager
{
    public List <Icommand> commands;
    
    
    public CommandManager()
    {
        commands = new List<Icommand>();
    }

    public void DoCommand(Icommand command)
    {
        commands.Add(command);
        command.Execute();
    }
    
    public void UndoCommand()
    {
        if (commands.Count > 0)
        {
            Icommand command = commands[commands.Count - 1];
            command.Undo();
            commands.Remove(command);
        }
    }
}
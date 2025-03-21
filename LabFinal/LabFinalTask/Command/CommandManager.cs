using LabFinalTask.ENUM;

namespace LabFinalTask.Command;

public class CommandManager
{
    public List<ICommand> commands;
    public List<ICommand> undoneCommands;
    public List<CommandLog> commandLogs;

    public CommandManager()
    {
        commands = new List<ICommand>();
        undoneCommands = new List<ICommand>();
        commandLogs = new List<CommandLog>();
    }
    
    public void ExecuteCommand(ICommand command)
    {
        commands.Add(command);
        command.execute();
        undoneCommands.Clear();
        commandLogs.Add(new CommandLog(command, COMMANDTYPE.EXECUTE));
    }

    public void UndoCommand()
    {
        if (commands.Count > 0)
        {
            ICommand command = commands[commands.Count - 1];
            command.undo();
            commands.Remove(command);
            undoneCommands.Add(command);
            commandLogs.Add(new CommandLog(command, COMMANDTYPE.UNDO));
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
            commandLogs.Add(new CommandLog(command, COMMANDTYPE.REDO));
        }
    }


    public int GetCommandCount()
    {
        return commands.Count;
    }

    
}
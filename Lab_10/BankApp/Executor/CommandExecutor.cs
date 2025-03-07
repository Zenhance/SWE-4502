using BankApp.Commands;

namespace BankApp.Executor;

public class CommandExecutor
{
    private List<ICommand> _commands = new();

    public void ExecuteCommand(ICommand command)
    {
        _commands.Add(command);
        command.Execute();
    }

    public void CommandHistory()
    {
        Console.WriteLine("\nCommand History");
        foreach (ICommand cmd in _commands)
        {
            cmd.Signature();
        }
    }
}
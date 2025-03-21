using LabFinalTask.ENUM;

namespace LabFinalTask.Command;

public class CommandLog
{
    public ICommand Command;
    public COMMANDTYPE Commandtype;
    private string type;
    public DateTime timestamp;

    public CommandLog(ICommand command, COMMANDTYPE commandtype)
    {
        Command = command;
        Commandtype = commandtype;
        timestamp = DateTime.Now;
    }
}
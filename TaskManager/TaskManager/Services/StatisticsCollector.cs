using System.Collections.Generic;
using TaskManager.Commands;
namespace TaskManager.Services;

public class StatisticsCollector
{
    private readonly Dictionary<CommandType, int> _commandcounts=new Dictionary<CommandType, int>();

    public void TrackCommand(Command command)
    {
        if (_commandcounts.ContainsKey(command.Type))
        {
            _commandcounts[command.Type]++;
        }
        else
        {
            _commandcounts[command.Type] = 1;
        }
    }

    public int GetCommandCount(CommandType type)
    {
        return _commandcounts.ContainsKey(type) ? _commandcounts[type] : 0;
    }
}
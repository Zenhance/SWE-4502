namespace LabFinal;

public class StatisticsCollector
{
    private readonly Dictionary<CommandType, int> _commandCounts = new Dictionary<CommandType, int>();

    public void TrackCommand(ICommand command)
    {
        var type = command.GetLog().Type;
        if (_commandCounts.ContainsKey(type))
            _commandCounts[type]++;
        else
            _commandCounts[type] = 1;
    }

    public int GetCommandCount(CommandType type)
    {
        return _commandCounts.ContainsKey(type) ? _commandCounts[type] : 0;
    }
}
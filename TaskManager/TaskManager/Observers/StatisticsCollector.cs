using TaskManager.Commands;

namespace TaskManager.Observers;

public class StatisticsCollector : IObserver
{
    private int _totalIssuesCreatedInLifetime;
    private readonly Dictionary<CommandType, int> _commandCounts = new Dictionary<CommandType, int>
    {
        { CommandType.Create, 0 },
        { CommandType.Update, 0 },
        { CommandType.Delete, 0 }
    };

    public void Update(ICommand command)
    {
        // Update command type counts
        _commandCounts[command.Type]++;

        // Update specific statistics
        if (command.Type == CommandType.Create)
        {
            _totalIssuesCreatedInLifetime++;
        }
        
    }

    public Dictionary<CommandType, int> GetCommandCounts()
    {
        return new Dictionary<CommandType, int>(_commandCounts);
    }

    public int GetIssuesCreated() => _totalIssuesCreatedInLifetime;
}
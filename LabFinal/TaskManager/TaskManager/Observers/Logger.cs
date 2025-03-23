using TaskManager.Commands;

namespace TaskManager.Observers;

public class Logger : IObserver
{
    private readonly List<string> _logs = [];

    public void Update(ICommand command)
    {
        var logEntry = $"[{command.Timestamp}] {command.Description}";
        _logs.Add(logEntry);
        Console.WriteLine($"LOG: {logEntry}");
    }

    public IEnumerable<string> GetLogs()
    {
        return _logs.AsReadOnly();
    }
}
using TaskManager.Commands;
using TaskManager.Observers;

namespace TaskManager.Subjects;

public class CommandManager : ISubject
{
    private readonly List<IObserver> _observers = [];
    private readonly Stack<ICommand> _executedCommands = new();
    private readonly Stack<ICommand> _undoneCommands = new ();

    public void RegisterObserver(IObserver observer)
    {
        if (!_observers.Contains(observer))
            _observers.Add(observer);
    }

    public void RemoveObserver(IObserver observer)
    {
        _observers.Remove(observer);
    }

    public void NotifyObservers(ICommand command)
    {
        foreach (var observer in _observers)
        {
            observer.Update(command);
        }
    }

    public void ExecuteCommand(ICommand command)
    {
        command.Execute();
        _executedCommands.Push(command);
        _undoneCommands.Clear();
        NotifyObservers(command);
    }

    public bool CanUndo() => _executedCommands.Count > 0;
    public bool CanRedo() => _undoneCommands.Count > 0;

    public void Undo()
    {
        if (!CanUndo()) return;

        var command = _executedCommands.Pop();
        command.Undo();
        _undoneCommands.Push(command);
        NotifyObservers(command);
    }

    public void Redo()
    {
        if (!CanRedo()) return;

        var command = _undoneCommands.Pop();
        command.Execute();
        _executedCommands.Push(command);
        NotifyObservers(command);
    }

    public IEnumerable<ICommand> GetCommandHistory()
    {
        return _executedCommands.Reverse();
    }
}
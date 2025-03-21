using System.Collections.Generic;
using TaskManager.Observers;
namespace TaskManager.Commands;

public class CommandManager
{
    private readonly Stack<Command> _undoStack = new Stack<Command>();
    private readonly Stack<Command> _redoStack = new Stack<Command>();
    private readonly List<IObserver> _observers = new List<IObserver>();

    public void RegisterObserver(IObserver observer)
    {
        _observers.Add(observer);
        
    }

    public void RemoveObserver(IObserver observer)
    {
        _observers.Remove(observer);
    }
    
    private void NotifyObservers(string message)
    {
        foreach (var observer in _observers)
        {
            observer.Update(message);
        }
    }
    public void ExecuteCommand(Command command)
    {     command.Execute();
        _undoStack.Push(command);
        _redoStack.Clear();
        NotifyObservers($"Command executed: {command.Description}");
    }
    
    public void Redo()
    {
        if (_redoStack.Count > 0)
        {
            var command = _redoStack.Pop();
            command.Execute();
            _redoStack.Push(command);
            NotifyObservers($"Command redone: {command.Description}");
        }
    }

    public void Undo()
    {
        if (_undoStack.Count > 0)
        {
            var command = _undoStack.Pop();
            command.Execute();
            _undoStack.Push(command);
            NotifyObservers($"Command undone: {command.Description}");
        }
    }
}
using System.Collections.Generic;
namespace TaskManager.Commands;

public class CommandManager
{
    private readonly Stack<Command> _undoStack = new Stack<Command>();
    private readonly Stack<Command> _redoStack = new Stack<Command>();

    public void ExecuteCommand(Command command)
    {     command.Execute();
        _undoStack.Push(command);
        _redoStack.Clear();
    }
    
    public void Redo()
    {
        if (_redoStack.Count > 0)
        {
            var command = _redoStack.Pop();
            command.Execute();
            _undoStack.Push(command);
        }
    }
}
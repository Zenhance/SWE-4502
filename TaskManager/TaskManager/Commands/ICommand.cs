namespace TaskManager.Commands;

public interface ICommand
{
    void Execute();
    void Undo();
    string Description { get; }
    DateTime Timestamp { get; }
    CommandType Type { get; }
}
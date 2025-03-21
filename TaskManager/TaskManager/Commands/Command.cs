using System;
namespace TaskManager.Commands;

public abstract class Command
{
    public abstract void Execute();
    public abstract void Undo();
    public string Description{ get; set; }
    public DateTime Timestamp { get; set; }
    public CommandType Type { get; set; }
}

public enum CommandType
{
    Create,
    Update,
    Delete
}
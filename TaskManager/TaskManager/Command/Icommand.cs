namespace TaskManagerOriginal.Command;

public interface Icommand
{
    public void Execute();

    public void Undo();
}
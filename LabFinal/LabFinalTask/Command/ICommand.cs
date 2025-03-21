namespace LabFinalTask.Command;

public interface ICommand
{
    void execute();
    void undo();
}
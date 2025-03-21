namespace LabFinal;

public interface ICommand
{
    void Execute();
    void Undo();
    CommandLog GetLog();
}
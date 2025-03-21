namespace LabFinal;

interface ICommand;

public interface Command
{
    void Execute();
    void Undo();
    
    CommandLog GetLog();
    
}
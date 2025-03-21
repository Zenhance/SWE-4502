namespace LabFinal;

interface Icommand;

public interface Command
{
    void Execute();
    void Undo();
    
}
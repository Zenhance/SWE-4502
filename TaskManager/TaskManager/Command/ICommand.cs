//Command Interface
namespace TaskManager.Command;

public interface ICommand
{
    void execute();
    void undo();
}
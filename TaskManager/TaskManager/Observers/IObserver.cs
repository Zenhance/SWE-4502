using TaskManager.Commands;

namespace TaskManager.Observers;

public interface IObserver
{
    void Update(ICommand command);
}
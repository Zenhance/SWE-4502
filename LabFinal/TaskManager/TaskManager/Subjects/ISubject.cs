using TaskManager.Commands;
using TaskManager.Observers;

namespace TaskManager.Subjects;

public interface ISubject
{
    void RegisterObserver(IObserver observer);
    void RemoveObserver(IObserver observer);
    void NotifyObservers(ICommand command);
}
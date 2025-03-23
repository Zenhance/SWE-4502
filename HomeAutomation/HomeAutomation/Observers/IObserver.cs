using HomeAutomation.Observables;

namespace HomeAutomation.Observers;

public interface IObserver
{
    void Update(HomeEnvironmentData data);
}
import java.util.ArrayList;
import java.util.List;

public class HomeAutomationSystem implements Subject
{
    private List<Observer> observers;
    private SystemState systemState;

    public HomeAutomationSystem()
    {
        this.observers = new ArrayList<>();
        this.systemState = new SystemState();
    }

    @Override
    public void registerObserver(Observer observer)
    {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer)
    {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers()
    {
        for (Observer observer : observers)
        {
            observer.update(systemState);
        }
    }

    public void setSystemState(SystemState systemState)
    {
        this.systemState = systemState;
        notifyObservers();
    }

    public SystemState getSystemState()
    {
        return systemState;
    }
}

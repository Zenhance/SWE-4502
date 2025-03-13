import java.util.ArrayList;
import java.util.List;

public class HomeAutomationSystem implements Subject {
    private List<Observer> observers;
    private EnvironmentalState state;

    public HomeAutomationSystem() {
        this.observers = new ArrayList<>();
        this.state = new EnvironmentalState();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }

    public void setState(EnvironmentalState newState) {
        this.state = newState;
        notifyObservers();
    }
}

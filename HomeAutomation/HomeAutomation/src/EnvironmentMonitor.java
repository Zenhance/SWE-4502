import java.util.ArrayList;
import java.util.List;

public class EnvironmentMonitor {
    public List<Observer> observers = new ArrayList<>();
    public EnvironmentState state = new EnvironmentState();

    // Set the new state and notify observers
    public void setState(EnvironmentState state) {
        this.state = state;
        notifyObservers();  // Notify all observers when the state changes
    }

    // Register an observer
    public void registerObserver(Observer observer) {
        observers.add(observer);  // Add observer to the list
    }

    // Remove an observer
    public void removeObserver(Observer observer) {
        observers.remove(observer);  // Remove observer from the list
    }

    // Notify all observers about the state change
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);  // Notify observers about the updated state
        }
    }
}

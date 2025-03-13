import java.util.List;      // Add this import
import java.util.ArrayList; // Also add this import for the ArrayList implementation

public class EnvironmentState {
    private List<Observer> observers = new ArrayList<>();  // Now List will be recognized
    private String state;
    private Object value;

    // Add an observer
    public void addObserver(Observer observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
        }
    }

    // Remove an observer
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Set the state and notify observers
    public void setState(String state, Object value) {
        this.state = state;
        this.value = value;
        notifyObservers();
    }

    // Notify all observers
    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state, value);
        }
    }

    // Add this method to get the list of observers
    public List<Observer> getObservers() {
        return observers;
    }
}

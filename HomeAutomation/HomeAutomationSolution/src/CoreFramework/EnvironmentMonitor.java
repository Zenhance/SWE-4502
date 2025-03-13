package CoreFramework;

import java.util.ArrayList;
import java.util.List;

// Manages environmental state and notifies observers of changes
public class EnvironmentMonitor {
    private List<Observer> observers = new ArrayList<>();
    private EnvironmentState currentState;

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setState(EnvironmentState newState) {
        this.currentState = newState;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(currentState);
        }
    }
}

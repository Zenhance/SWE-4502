import java.util.ArrayList;
import java.util.List;

public class Subject {
    private final List<Observer> observers = new ArrayList<>();

    // This method is to register observers
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    // This method isto remove observers
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // This method is to notify all observers when state changes
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

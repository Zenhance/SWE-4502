import java.util.ArrayList;
import java.util.List;

public class Subject {
    private final List<IObserver> observers = new ArrayList<>();

    public void registerObserver(IObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    public void notifyAllObservers(String message) {
        for (IObserver observer : observers) {
            observer.update(message);
        }
    }
}

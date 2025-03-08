import java.util.*;

public class SystemStateManager {
    public List<IObserver> observers = new ArrayList<>();
    public SystemState state = new SystemState();

    public void registerObserver(IObserver IObserver) {
        observers.add(IObserver);
    }

    public void removeObserver(IObserver IObserver) {
        observers.remove(IObserver);
    }

    private void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update(state);
        }
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class EnvironmentState {
    private final List<Observer> observers = new ArrayList<>();
    private final Map<String, Object> stateMap = new HashMap<>();

    public synchronized void addObserver(Observer observer) {
        observers.add(observer);
    }

    public synchronized void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public synchronized void setState(String state, Object value) {
        stateMap.put(state, value);
        notifyObservers(state, value);
    }

    public synchronized Object getState(String state) {
        return stateMap.getOrDefault(state, null);
    }

    private void notifyObservers(String state, Object value) {
        if (observers.isEmpty()) {
            System.out.println("No observers registered. Skipping notification.");
            return;
        }

        for (Observer observer : observers) {
            observer.update(state, value);
        }
    }
}

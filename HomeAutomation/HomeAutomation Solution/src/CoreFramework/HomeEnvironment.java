package CoreFramework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeEnvironment implements Subject {
    private static HomeEnvironment instance; // Singleton
    private Map<String, List<Observer>> observers = new HashMap<>();
    private Map<String, Object> state = new HashMap<>();

    private HomeEnvironment() {}

    public static HomeEnvironment getInstance() {
        if (instance == null) {
            instance = new HomeEnvironment();
        }
        return instance;
    }

    @Override
    public void registerObserver(String eventType, Observer observer) {
        observers.computeIfAbsent(eventType, k -> new ArrayList<>()).add(observer);
    }

    @Override
    public void removeObserver(String eventType, Observer observer) {
        if (observers.containsKey(eventType)) {
            observers.get(eventType).remove(observer);
        }
    }

    @Override
    public void notifyObservers(String eventType, Object value) {
        if (observers.containsKey(eventType)) {
            for (Observer observer : observers.get(eventType)) {
                observer.update(eventType, value);
            }
        }
    }

    public void setState(String key, Object value) {
        state.put(key, value);
        notifyObservers(key, value);
    }

    public Object getState(String key) {
        return state.get(key);
    }
}

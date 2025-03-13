package core;

import java.util.*;

public class HomeSystem {
    private static HomeSystem instance;
    private final Map<String, Object> environmentalState;
    private final Map<EventType, List<HomeSystemObserver>> observers;

    public HomeSystem() {
        environmentalState = new HashMap<>();
        observers = new HashMap<>();
        for (EventType type : EventType.values()) {
            observers.put(type, new ArrayList<>());
        }
    }

    public static synchronized HomeSystem getInstance() {
        if (instance == null) {
            instance = new HomeSystem();
        }
        return instance;
    }

    public void registerObserver(EventType eventType, HomeSystemObserver observer) {
        observers.get(eventType).add(observer);
    }

    public void removeObserver(EventType eventType, HomeSystemObserver observer) {
        observers.get(eventType).remove(observer);
    }

    public void notifyObservers(EventType eventType, Map<String, Object> data) {
        for (HomeSystemObserver observer : observers.get(eventType)) {
            observer.update(eventType, data);
        }
    }

    public void updateState(String key, Object value) {
        environmentalState.put(key, value);
    }

    public Object getState(String key) {
        return environmentalState.get(key);
    }

    public Map<String, Object> getFullState() {
        return new HashMap<>(environmentalState);
    }

    // For testing purposes
    public void reset() {
        environmentalState.clear();
        for (EventType type : EventType.values()) {
            observers.get(type).clear();
        }
    }
}

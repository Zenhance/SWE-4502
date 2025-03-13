package lab11_210042164.implementation.manager;

import lab11_210042164.implementation.interfaces.Component;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StateManager {
    private Map<String, Object> state = new HashMap<>();
    private Map<String, Set<Component>> subscribers = new HashMap<>();

    public void subscribe(String key, Component component) {
        if (!subscribers.containsKey(key)) {
            subscribers.put(key, new HashSet<>());
        }
        subscribers.get(key).add(component);
    }

    public void unsubscribe(String key, Component component) {
        if (subscribers.containsKey(key)) {
            subscribers.get(key).remove(component);
        }
    }

    public void updateState(String key, Object value) {
        state.put(key, value);
        notifySubscribers(key, value);
    }

    private void notifySubscribers(String key, Object value) {
        if (subscribers.containsKey(key)) {
            for (Component component : subscribers.get(key)) {
                component.onStateChange(key, value);
            }
        }
    }

    public Object getState(String key) {
        return state.get(key);
    }

    public Map<String, Object> getAllState() {
        return new HashMap<>(state);
    }
}

package java.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Measurement;

public class StateManager {
    private Map<EventType, List<EventListener>> listeners = new HashMap<>();
    private Map<EventType, Measurement> state = new HashMap<>();

    public void register(EventType type, EventListener listener) {
        listeners.computeIfAbsent(type, k -> new ArrayList<>()).add(listener);
    }

    public void remove(EventType type, EventListener listener) {
        if (listeners.containsKey(type)) {
            listeners.get(type).remove(listener);
        }
    }

    public void setState(EventType type, Measurement measurement) {
        state.put(type, measurement);
        publishEvent(new Event(type, measurement));
    }

    public Measurement getState(EventType type) {
        return state.get(type);
    }

    private void publishEvent(Event event) {
        List<EventListener> interestedListeners = listeners.get(event.getType());
        if (interestedListeners != null) {
            for (EventListener listener : interestedListeners) {
                listener.onEvent(event);
            }
        }
    }
}

package org.example;

import java.util.Map;

// Observer interface for components to implement
public interface HomeSystemObserver {
    void update(EventType eventType, Map<String, Object> data);
}

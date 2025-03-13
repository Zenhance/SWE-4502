package main.Code.components;

import core.EventType;
import core.HomeSystem;
import core.HomeSystemObserver;
import java.util.Map;

public interface LightManager extends HomeSystemObserver {
    void update(EventType eventType, Map<String, Object> data);

    void setLightLevel(String room, int level);
    int getLightLevel(String room);
    void setScene(String room, String scene);
    String getCurrentScene(String room);
    void adjustBasedOnOccupancy(String room, boolean occupied);

    boolean isLightAdjusted(String kitchen, boolean b);
}

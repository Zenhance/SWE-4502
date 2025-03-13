package main.Code.components;

import core.EventType;
import core.HomeSystem;
import core.HomeSystemObserver;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface MotionDetector extends HomeSystemObserver {
    void detectMotion(String location, LocalDateTime timestamp);
    boolean isMotionDetected(String location);
    List<Map<String, Object>> getMotionHistory();
    boolean isActivitySuspicious(String location);

    void update(core.EventType eventType, Map<String, Object> mockData);
}

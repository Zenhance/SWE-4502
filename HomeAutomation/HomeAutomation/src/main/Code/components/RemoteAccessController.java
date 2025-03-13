package components;

import core.EventType;
import core.HomeSystem;
import core.HomeSystemObserver;
import java.util.List;
import java.util.Map;

public interface RemoteAccessController extends HomeSystemObserver {
    Map<String, Object> getHomeStatus();
    List<Map<String, Object>> getNotifications();
    void executeCommand(String command, Map<String, Object> parameters);
    void addNotification(String type, String message);
}

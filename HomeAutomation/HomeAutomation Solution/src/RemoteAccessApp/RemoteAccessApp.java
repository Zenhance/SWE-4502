package RemoteAccessApp;

import Commands.Command;
import CoreFramework.HomeEnvironment;
import CoreFramework.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoteAccessApp implements Observer {
    private Map<String,Object> currentState = new HashMap<>();
    private List<String> notifications=new ArrayList<>();

    public RemoteAccessApp() {
        // Register for all relevant events
        HomeEnvironment env = HomeEnvironment.getInstance();
        env.registerObserver("temperature", this);
        env.registerObserver("motion", this);
        env.registerObserver("powerUsage", this);
        env.registerObserver("roomOccupancy", this);
    }
    @Override
    public void update(String eventType, Object value) {
        // Update our local state
        currentState.put(eventType, value);

        // Generate notifications for important events
        if (eventType.equals("motion") && value instanceof Boolean && (Boolean) value) {
            addNotification("Motion detected at home");
        } else if (eventType.equals("powerUsage") && value instanceof Double) {
            double usage = (Double) value;
            if (usage > 5000) {
                addNotification("High power usage detected: " + usage + " watts");
            }
        }
    }
    public void addNotification(String message) {
        notifications.add(message);
        System.out.println("NOTIFICATION: " + message);
    }

    public void sendCommand(Command command) {
        command.execute();
    }

    public Map<String, Object> getCurrentState() {
        return new HashMap<>(currentState);
    }

    public List<String> getNotifications() {
        return new ArrayList<>(notifications);
    }

}

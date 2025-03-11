package Code.Controllers;

import Code.Interfaces.Component;
import Code.StateManagementClasses.StateManager;
import java.util.HashMap;
import java.util.Map;

public class RemoteAccessApp implements Component {
    private StateManager stateManager;
    private Map<String, Object> homeState = new HashMap<>();

    public RemoteAccessApp(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    @Override
    public void onStateChange(String key, Object value) {
        homeState.put(key, value);
        System.out.println("Remote access app updated: " + key + " = " + value);
        generateNotification(key, value);
    }

    public void generateNotification(String key, Object value) {
        if ("temperature".equals(key) && (double) value > 30.0) {
            System.out.println("ALERT: High temperature detected: " + value + "°C");
        } else if ("doorStatus".equals(key) && "open".equals(value)) {
            System.out.println("ALERT: Door is open!");
        }
    }

    public void remoteControl(String key, Object value) {
        stateManager.updateState(key, value);
        System.out.println("Remote control command: " + key + " set to " + value);
    }

    public Object getState(String key) {
        return homeState.get(key);
    }
}
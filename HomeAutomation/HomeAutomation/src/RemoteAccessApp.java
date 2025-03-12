import java.util.HashMap;
import java.util.Map;

public class RemoteAccessApp implements Observer {
    private final Map<String, Object> currentState = new HashMap<>();


    public void update(EnvironmentState state) {
        updateCurrentState(state);

        displayState();

        generateNotifications();
    }

    private void updateCurrentState(EnvironmentState state) {
        for (String key : new String[]{"motion", "lightLevel", "occupancy", "temperature", "powerUsage", "voiceCommand"}) {
            Object value = state.getState(key);
            if (value != null) {
                currentState.put(key, value);
            }
        }
    }

    private void displayState() {
        System.out.println(" Remote Access App - Home Environment State:");
        for (Map.Entry<String, Object> entry : currentState.entrySet()) {
            System.out.println("  - " + entry.getKey() + ": " + entry.getValue());
        }
    }

    private void generateNotifications() {
        if (Boolean.TRUE.equals(currentState.get("motion"))) {
            System.out.println(" Alert: Motion detected in the home!");
        }
        if (Integer.valueOf(1000).equals(currentState.get("powerUsage"))) {
            System.out.println("⚠ Warning: High power consumption detected!");
        }
        if (Double.valueOf(15.0).equals(currentState.get("temperature"))) {
            System.out.println(" Info: Temperature is low, consider turning on the heater.");
        }
    }

    // Remote control method to manually update the system
    public void remoteControl(String key, Object value, HomeAutomation hub) {
        System.out.println(" Remote command issued: Setting " + key + " to " + value);
        hub.updateState(key, value);
    }
}

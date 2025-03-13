import java.util.ArrayList;
import java.util.List;

public class RemoteAccessApp implements Observer {
    private EnvironmentMonitor monitor;
    public List<String> notifications = new ArrayList<>();

    public RemoteAccessApp(EnvironmentMonitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void update(EnvironmentState state) {
        displayCurrentState(state);
        checkForImportantEvents(state);
    }

    // Display the current state
    public void displayCurrentState(EnvironmentState state) {
        System.out.println("Current Environment State: " + state);
    }

    // Check for important events and notify
    private void checkForImportantEvents(EnvironmentState state) {
        if (state.motionDetected) {
            notifications.add("Alert: Motion detected!");
        }
        if (state.temperature > 30 || state.temperature < 15) {
            notifications.add("Warning: Unusual temperature detected - " + state.temperature + "°C");
        }
    }

    // Simulate remote control actions
    public void controlLights(boolean turnOn, double brightness) {
        EnvironmentState state = monitor.state;
        state.lightLevel = turnOn ? brightness : 0;
        monitor.setState(state);
        System.out.println("Remote Command: Lights " + (turnOn ? "ON" : "OFF") + " with brightness " + brightness);
    }

    public void setTemperature(double temperature) {
        EnvironmentState state = monitor.state;
        state.temperature = temperature;
        monitor.setState(state);
        System.out.println("Remote Command: Set temperature to " + temperature + "°C");
    }

    public List<String> getNotifications() {
        return notifications;
    }

}

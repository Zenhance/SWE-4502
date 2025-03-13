package RemoteAccess;
import Core.HomeEnvironment;
import Core.Observer;

public class RemoteAccess implements Observer {
    private HomeEnvironment homeEnvironment;

    public RemoteAccess() {
        homeEnvironment = HomeEnvironment.getInstance();
        homeEnvironment.registerObserver("lightState", this);  // Register for light state changes
        homeEnvironment.registerObserver("temperature", this);  // Register for temperature changes
    }

    @Override
    public void update(String eventType, Object value) {
        if (eventType.equals("lightState")) {
            displayLightStatus((String) value);  // Display light status (on or off)
        } else if (eventType.equals("temperature")) {
            displayTemperature((Integer) value);  // Display the current temperature
        }
    }

    // Method to display the light status
    private void displayLightStatus(String lightStatus) {
        System.out.println("Light Status: " + lightStatus);
        sendNotification("Light status has changed to: " + lightStatus);
    }

    // Method to display the current temperature
    private void displayTemperature(int temperature) {
        System.out.println("Current Temperature: " + temperature + "°C");
        sendNotification("Temperature has been set to: " + temperature + "°C");
    }

    // Method to generate notifications
    private void sendNotification(String message) {
        System.out.println("Notification: " + message);
    }

    // Remote control to turn the light on or off
    public void controlLight(String command) {
        if (command.equalsIgnoreCase("turn on the light")) {
            homeEnvironment.setState("lightState", "on");
        } else if (command.equalsIgnoreCase("turn off the light")) {
            homeEnvironment.setState("lightState", "off");
        } else {
            System.out.println("Invalid command for light.");
        }
    }

    // Remote control to set the temperature
    public void controlTemperature(int temperature) {
        homeEnvironment.setState("temperature", temperature);
    }
}
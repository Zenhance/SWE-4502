import java.util.List;
import java.util.ArrayList;

public class RemoteAccessApp implements Observer {
    public String homeStatus;
    public final List<String> commandHistory = new ArrayList<>();
    public HomeState state;

    // Constructor - This is where the RemoteAccessApp subscribes to updates
    public RemoteAccessApp(Subject subject) {
        this.state = (HomeState) subject;  // Set the state (HomeState extends Subject)
        subject.registerObserver(this); // Register this observer to the subject
    }

    @Override
    public void update(String message) {
        this.homeStatus = message;
    }

    // Method to display the current home system status
    public String displayCurrentState() {
        return "Home System Status:\n" +
                "Motion Detected: " + (state.motionDetected ? "Yes" : "No") + "\n" +
                "Room Occupied: " + (state.roomOccupied ? "Yes" : "No") + "\n" +
                "Light Level: " + state.lightLevel + "\n" +
                "Lights On: " + (state.setLightsOn ? "Yes" : "No") + "\n" +
                "Temperature: " + state.temperature + "°C\n" +
                "Energy Usage: " + state.energyUsage + " watts";
    }

    // Method to generate notifications
    public String generateNotification(String message) {
        return "NOTIFICATION: " + message;
    }

    // Allow remote control of home systems (Lights, Temperature, etc.)
    public String remoteControl(String command, Subject subject) {
        if (command.toLowerCase().contains("turn on the lights")) {
            state.setLightsOn = true;
            subject.notifyObservers("Lights turned ON");
            commandHistory.add("turn on the lights");  // Add to history
            return generateNotification("Lights turned ON remotely.");
        } else if (command.toLowerCase().contains("turn off the lights")) {
            state.setLightsOn = false;
            subject.notifyObservers("Lights turned OFF");
            commandHistory.add("turn off the lights");  // Add to history
            return generateNotification("Lights turned OFF remotely.");
        } else if (command.toLowerCase().contains("increase temperature")) {
            state.temperature += 2;
            subject.notifyObservers("Temperature increased");
            commandHistory.add("increase temperature");  // Add to history
            return generateNotification("Temperature increased remotely.");
        } else if (command.toLowerCase().contains("decrease temperature")) {
            state.temperature -= 2;
            subject.notifyObservers("Temperature decreased");
            commandHistory.add("decrease temperature");  // Add to history
            return generateNotification("Temperature decreased remotely.");
        } else if (command.toLowerCase().contains("increase energy usage")) {
            state.energyUsage += 100;
            subject.notifyObservers("Energy usage increased");
            commandHistory.add("increase energy usage");  // Add to history
            return generateNotification("Energy usage increased remotely.");
        } else if (command.toLowerCase().contains("decrease energy usage")) {
            state.energyUsage -= 100;
            subject.notifyObservers("Energy usage decreased");
            commandHistory.add("decrease energy usage");  // Add to history
            return generateNotification("Energy usage decreased remotely.");
        } else {
            return "ERROR: Unrecognized command!";
        }
    }


    // Return history of commands received
    public List<String> getCommandHistory() {
        return commandHistory;
    }
}

import java.util.ArrayList;
import java.util.List;

public class VoiceCommandProcessor {
    public List<String> commandHistory = new ArrayList<>();
    private EnvironmentMonitor monitor;

    public VoiceCommandProcessor(EnvironmentMonitor monitor) {
        this.monitor = monitor;
    }

    // Process a voice command and update the system state accordingly
    public void processCommand(String command) {
        commandHistory.add(command);  // Save the command to history
        System.out.println("Processing command: " + command);

        if (command.equalsIgnoreCase("turn on lights")) {
            EnvironmentState newState = monitor.state;
            newState.lightLevel = 70;  // Assume 70 is the standard "on" brightness
            monitor.setState(newState);
        } else if (command.equalsIgnoreCase("turn off lights")) {
            EnvironmentState newState = monitor.state;
            newState.lightLevel = 0;
            monitor.setState(newState);
        } else if (command.startsWith("set temperature to ")) {
            try {
                double temp = Double.parseDouble(command.replaceAll("[^0-9.]", ""));
                EnvironmentState newState = monitor.state;
                newState.temperature = temp;
                monitor.setState(newState);
            } catch (NumberFormatException e) {
                System.out.println("Invalid temperature value.");
            }
        } else {
            System.out.println("Unknown command.");
        }
    }

    // Get command history for validation and reporting
    public List<String> getCommandHistory() {
        return commandHistory;
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class VoiceCommandSystem {
    private static final Logger logger = Logger.getLogger(VoiceCommandSystem.class.getName());
    private List<String> commandHistory = new ArrayList<>();

    private boolean lightsOn = false;
    private double targetTemperature = 22.0;

    // Method to process a natural language command
    public void processCommand(String command) {
        commandHistory.add(command);  // Store the command in history

        if (command.toLowerCase().contains("turn on the lights")) {
            lightsOn = true;
            logger.info("Lights turned ON.");
        } else if (command.toLowerCase().contains("turn off the lights")) {
            lightsOn = false;
            logger.info("Lights turned OFF.");
        } else if (command.toLowerCase().contains("set temperature to")) {
            try {
                int temp = Integer.parseInt(command.replaceAll("[^0-9]", ""));  // Extract temperature value
                targetTemperature = temp;
                logger.info("Temperature set to " + temp + "°C.");
            } catch (NumberFormatException e) {
                logger.warning("Invalid temperature value in command: " + command);
            }
        } else {
            logger.warning("Unrecognized command: " + command);
        }
    }

    // Get the current state of the lights
    public boolean areLightsOn() {
        return lightsOn;
    }

    // Get the current target temperature
    public double getTargetTemperature() {
        return targetTemperature;
    }

    // Get the history of commands
    public List<String> getCommandHistory() {
        return commandHistory;
    }
}

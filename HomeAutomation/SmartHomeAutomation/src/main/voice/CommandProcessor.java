package voice;

import core.StateManager;

public class CommandProcessor {
    private StateManager stateManager;

    public CommandProcessor(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    public void processCommand(String command) {
        if (command.equalsIgnoreCase("turn on lights")) {
            // Logic to turn on lights
        } else if (command.equalsIgnoreCase("turn off lights")) {
            // Logic to turn off lights
        } else if (command.equalsIgnoreCase("increase temperature")) {
            // Logic to increase temperature
        } else {
            // Handle unknown command
        }
    }

    public String getLastProcessedCommand() {
        // Logic to retrieve the last processed command
        return "Last command";
    }
}

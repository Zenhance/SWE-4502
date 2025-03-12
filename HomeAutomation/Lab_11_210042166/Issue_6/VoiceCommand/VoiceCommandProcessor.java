package Lab_11_210042166.Issue_6.VoiceCommand;

import Lab_11_210042166.Project_Structure.Interface.Component;
import Lab_11_210042166.Project_Structure.StateManager_Class.StateManager;
import Lab_11_210042166.Project_Structure.Storage_Class.EnvironmentState;

import java.util.ArrayList;
import java.util.List;

public class VoiceCommandProcessor implements Component {
    private StateManager stateManager;
    private List<String> commandHistory;

    public VoiceCommandProcessor(StateManager stateManager) {
        this.stateManager = stateManager;
        this.commandHistory = new ArrayList<>();
    }

    public void processCommand(String command) {
        commandHistory.add(command);
        System.out.println("Processing command: " + command);
        executeCommand(command);
    }

    private void executeCommand(String command) {
        EnvironmentState currentState = stateManager.getCurrentState(); // Get the latest state

        if (command.equalsIgnoreCase("turn on lights")) {
            currentState.setLightsOn(true);
            stateManager.updateState(currentState);
        } else if (command.equalsIgnoreCase("turn off lights")) {
            currentState.setLightsOn(false);
            stateManager.updateState(currentState);
        } else if (command.equalsIgnoreCase("increase temperature")) {
            currentState.setTemperature(currentState.getTemperature() + 2);
            stateManager.updateState(currentState);
        } else if (command.equalsIgnoreCase("decrease temperature")) {
            currentState.setTemperature(currentState.getTemperature() - 2);
            stateManager.updateState(currentState);
        } else {
            System.out.println("Unknown command.");
        }
    }

    public List<String> getCommandHistory() {
        return commandHistory;
    }

    @Override
    public void update(EnvironmentState state) {
        // No direct update from state needed for voice commands
    }
}

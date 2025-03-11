package Code.Controllers;

import Code.Interfaces.Component;
import Code.StateManagementClasses.StateManager;
import java.util.ArrayList;
import java.util.List;

public class VoiceCommandSystem implements Component {
    private StateManager stateManager;
    private List<String> commandHistory = new ArrayList<>();

    public VoiceCommandSystem(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    @Override
    public void onStateChange(String key, Object value) {
        if ("voiceCommand".equals(key) && value instanceof String) {
            processVoiceCommand((String) value);
        }
    }

    private void processVoiceCommand(String command) {
        commandHistory.add(command);
        System.out.println("Processing voice command: " + command);

        switch (command.toLowerCase()) {
            case "turn on the lights":
                stateManager.updateState("lights", "on");
                System.out.println("Lights turned ON.");
                break;

            case "turn off the lights":
                stateManager.updateState("lights", "off");
                System.out.println("Lights turned OFF.");
                break;

            case "increase temperature":
                stateManager.updateState("temperature", "increase");
                System.out.println("Temperature increased.");
                break;

            case "decrease temperature":
                stateManager.updateState("temperature", "decrease");
                System.out.println("Temperature decreased.");
                break;

            default:
                System.out.println("Unknown voice command: " + command);
        }
    }

    public List<String> getCommandHistory() {
        return commandHistory;
    }
}
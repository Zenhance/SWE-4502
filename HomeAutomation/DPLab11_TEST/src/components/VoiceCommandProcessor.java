package components;

import core.IComponent;

import java.util.ArrayList;
import java.util.List;

public class VoiceCommandProcessor implements IComponent {

    private List<String> commandHistory;

    public VoiceCommandProcessor() {
        this.commandHistory = new ArrayList<>();
    }

    @Override
    public void onStateChanged(String newState, int value) {
        System.out.println("Processing voice command: " + newState);
    }

    public void processCommand(String command) {
        addToHistory(command);

        if (command.contains("turn on")) {
            System.out.println("Turning on device");
        } else if (command.contains("turn off")) {
            System.out.println("Turning off device");
        } else {
            System.out.println("Command not recognized");
        }
    }

    public void translateCommand(String command) {
        addToHistory(command);

        if (command.contains("turn on")) {
            onStateChanged("on", 0);
        } else if (command.contains("turn off")) {
            onStateChanged("off", 0);
        }
    }

    private void addToHistory(String command) {
        commandHistory.add(command);
    }

    public List<String> getCommandHistory() {
        return commandHistory;
    }
}

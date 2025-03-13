import java.util.List;
import java.util.ArrayList;


public class VoiceCommandObserver implements Observer {
    private List<String> commandHistory = new ArrayList<>();

    @Override
    public void update(String message) {
        commandHistory.add(message);
        processCommand(message);
    }

    private void processCommand(String command) {

        if (command.contains("turn on") || command.contains("activate")) {
            System.out.println("Executing command: " + command);
        } else if (command.contains("turn off") || command.contains("deactivate")) {
            System.out.println("Executing command: " + command);
        } else {
            System.out.println("Unknown command: " + command);
        }
    }

    public List<String> getCommandHistory() {
        return commandHistory;
    }
}

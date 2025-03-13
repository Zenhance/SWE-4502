import java.util.ArrayList;
import java.util.List;

public class VoiceCommandProcessor implements Observer {
    private List<String> commandHistory = new ArrayList<>();

    @Override
    public void update(EnvironmentalState state) {
        System.out.println("Voice command system updated.");
    }

    public void processCommand(String command) {
        commandHistory.add(command);
        System.out.println("Executing command: " + command);
    }

    public List<String> getCommandHistory() {
        return commandHistory;
    }
}

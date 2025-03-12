import java.util.ArrayList;
import java.util.List;

public class VoiceCommandProcessor {
    private EnvironmentState envState;
    private List<String> commandHistory = new ArrayList<>();

    public VoiceCommandProcessor(EnvironmentState envState) {
        this.envState = envState;
    }

    public void processCommand(String command) {
        commandHistory.add(command);

        if (command.equalsIgnoreCase("TURN ON LIGHTS")) {
            envState.setState("LIGHT_LEVEL", 0);
        } else if (command.equalsIgnoreCase("TURN OFF LIGHTS")) {
            envState.setState("LIGHT_LEVEL", 100);
        } else if (command.equalsIgnoreCase("SET TEMPERATURE TO 24")) {
            envState.setState("TEMPERATURE", 24.0);
        } else {
            System.out.println("VoiceCommandProcessor: Command not recognized.");
        }
    }

    public List<String> getCommandHistory() {
        return commandHistory;
    }
}

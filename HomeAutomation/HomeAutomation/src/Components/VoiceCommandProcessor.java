package Components;

import Core.EnvironmentState;
import java.util.ArrayList;
import java.util.List;

public class VoiceCommandProcessor {
    private final EnvironmentState envState;
    private final List<String> commandHistory = new ArrayList<>();

    public VoiceCommandProcessor(EnvironmentState envState) {
        this.envState = envState;
    }

    public void processCommand(String command) {
        commandHistory.add(command);

        if ("TURN ON LIGHTS".equalsIgnoreCase(command)) {
            envState.setState("LIGHT_LEVEL", 0);
        } else if ("TURN OFF LIGHTS".equalsIgnoreCase(command)) {
            envState.setState("LIGHT_LEVEL", 100);
        } else if (command.startsWith("SET TEMPERATURE TO")) {
            try {
                double temperature = Double.parseDouble(command.replaceAll("[^0-9]", ""));
                envState.setState("TEMPERATURE", temperature);
            } catch (NumberFormatException e) {
                System.out.println("VoiceCommandProcessor: Invalid temperature command.");
            }
        } else {
            System.out.println("VoiceCommandProcessor: Command not recognized.");
        }
    }

    public List<String> getCommandHistory() {
        return new ArrayList<>(commandHistory);
    }
}

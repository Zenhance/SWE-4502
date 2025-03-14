package VoiceCommandSystem;

import java.util.HashMap;
import java.util.Map;

// Processes voice commands and executes corresponding actions
public class VoiceCommandProcessor {
    private Map<String, Command> commandMap = new HashMap<>();

    public void registerCommand(String commandName, Command command) {
        commandMap.put(commandName, command);
    }

    public void processCommand(String commandName) {
        Command command = commandMap.get(commandName);
        if (command != null) {
            command.execute();
        } else {
            System.out.println(" Unknown command: " + commandName);
        }
    }
}

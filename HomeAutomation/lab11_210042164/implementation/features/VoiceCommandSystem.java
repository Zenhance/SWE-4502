package lab11_210042164.implementation.features;

import lab11_210042164.implementation.manager.StateManager;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VoiceCommandSystem {
    private final StateManager stateManager;
    private final List<String> commandHistory;

    public VoiceCommandSystem(StateManager stateManager) {
        this.stateManager = stateManager;
        this.commandHistory = new ArrayList<>();
    }

    public void processCommand(String command) {
        // Add command to history
        commandHistory.add(command);

        // Process light commands
        if (processLightCommand(command)) {
            return;
        }

        // Process temperature commands
        if (processTemperatureCommand(command)) {
            return;
        }

        // Process scene commands
        if (processSceneCommand(command)) {
            return;
        }

        // If we got here, command was not recognized
        // No state changes are made
    }

    private boolean processLightCommand(String command) {
        command = command.toLowerCase();

        // Pattern for "turn on [room] lights" - allow multi-word room names
        Pattern turnOnPattern = Pattern.compile("turn on ([\\w\\s]+) lights");
        Matcher turnOnMatcher = turnOnPattern.matcher(command);

        if (turnOnMatcher.find()) {
            String room = turnOnMatcher.group(1).trim();
            // Capitalize each word in room name
            String[] words = room.split("\\s+");
            StringBuilder roomNameBuilder = new StringBuilder();
            for (String word : words) {
                roomNameBuilder.append(capitalizeFirstLetter(word));
            }
            String roomName = roomNameBuilder.toString();
            stateManager.updateState("lightLevel_" + roomName, 100);
            return true;
        }

        // Pattern for "turn off [room] lights" - allow multi-word room names
        Pattern turnOffPattern = Pattern.compile("turn off ([\\w\\s]+) lights");
        Matcher turnOffMatcher = turnOffPattern.matcher(command);

        if (turnOffMatcher.find()) {
            String room = turnOffMatcher.group(1).trim();
            // Capitalize each word in room name
            String[] words = room.split("\\s+");
            StringBuilder roomNameBuilder = new StringBuilder();
            for (String word : words) {
                roomNameBuilder.append(capitalizeFirstLetter(word));
            }
            String roomName = roomNameBuilder.toString();
            stateManager.updateState("lightLevel_" + roomName, 0);
            return true;
        }

        return false;
    }

    private boolean processTemperatureCommand(String command) {
        command = command.toLowerCase();

        // Pattern for "set temperature to [value] degrees"
        Pattern tempPattern = Pattern.compile("set temperature to (\\d+) degrees");
        Matcher tempMatcher = tempPattern.matcher(command);

        if (tempMatcher.find()) {
            double temperature = Double.parseDouble(tempMatcher.group(1));
            stateManager.updateState("targetTemperature", temperature);
            return true;
        }

        return false;
    }

    private boolean processSceneCommand(String command) {
        command = command.toLowerCase();

        // Pattern for "activate [scene] scene"
        Pattern scenePattern = Pattern.compile("activate (\\w+) scene");
        Matcher sceneMatcher = scenePattern.matcher(command);

        if (sceneMatcher.find()) {
            String scene = sceneMatcher.group(1);
            stateManager.updateState("lightScene", scene);
            return true;
        }

        return false;
    }

    public List<String> getCommandHistory() {
        return new ArrayList<>(commandHistory);
    }

    private String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
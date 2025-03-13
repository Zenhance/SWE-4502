package VoiceCommandSystem;
import Commands.*;
import java.util.ArrayList;
import java.util.List;

public class VoiceCommandSystem {
    private List<String> commandHistory = new ArrayList<>();

    public void processCommand(String voiceInput) {
        Command command = parseCommand(voiceInput);
        if (command != null) {
            commandHistory.add(voiceInput);
            command.execute();
            System.out.println("Executed command: " + voiceInput);
        } else {
            System.out.println("Could not parse command: " + voiceInput);
        }
    }

    private Command parseCommand(String voiceInput) {
        voiceInput = voiceInput.toLowerCase();

        if (voiceInput.contains("set temperature")) {
            try {
                String[] parts = voiceInput.split("to");
                if (parts.length > 1) {
                    double temp = Double.parseDouble(parts[1].trim());
                    return new SetTemperatureCommand(temp);
                }
            } catch (NumberFormatException e) {
                return null;
            }
        } else if (voiceInput.contains("set scene") || voiceInput.contains("change scene")) {
            if (voiceInput.contains("reading")) {
                return new SetLightSceneCommand("reading");
            } else if (voiceInput.contains("movie")) {
                return new SetLightSceneCommand("movie");
            } else if (voiceInput.contains("default")) {
                return new SetLightSceneCommand("default");
            }
        } else if (voiceInput.contains("i am leaving")) {
            return new ToggleRoomOccupancyCommand(false);
        } else if (voiceInput.contains("i am home")) {
            return new ToggleRoomOccupancyCommand(true);
        }

        return null;
    }

    public List<String> getCommandHistory() {
        return new ArrayList<>(commandHistory);
    }
}

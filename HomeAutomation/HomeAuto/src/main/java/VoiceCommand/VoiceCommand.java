package VoiceCommand;

import Core.Observer;
import Core.HomeEnvironment;
import java.util.ArrayList;
import java.util.List;

public class VoiceCommand implements Observer {
    private List<String> commandHistory;  // To store history of processed commands
    private HomeEnvironment homeEnvironment;
    public VoiceCommand() {
        commandHistory = new ArrayList<>();
    }

    @Override
    public void update(String eventType, Object value) {
        if (eventType.equals("voiceCommand")) {
            String command = (String) value;
            processCommand(command);
        }
    }

    private void processCommand(String command) {
        command = command.toLowerCase().trim();

        if (command.contains("turn on the light")) {
            homeEnvironment.setState("lightState", "on");
            System.out.println("The light has been turned on.");
        } else if (command.contains("turn off the light")) {
            homeEnvironment.setState("lightState", "off");
            System.out.println("The light has been turned off.");
        } else if (command.contains("set temperature to")) {
            int temperature = extractTemperature(command);
            homeEnvironment.setState("temperature", temperature);
            System.out.println("The temperature has been set to " + temperature + "°C.");
        } else if (command.contains("open the door")) {
            homeEnvironment.setState("doorState", "open");
            System.out.println("The door has been opened.");
        } else if (command.contains("close the door")) {
            homeEnvironment.setState("doorState", "closed");
            System.out.println("The door has been closed.");
        } else {
            System.out.println("Command not recognized: " + command);
        }
    }


    private int extractTemperature(String command) {
        String[] commandParts = command.split(" ");
        for (String part : commandParts) {
            try {
                return Integer.parseInt(part);
            } catch (NumberFormatException e) {
                // Ignore if the part is not a number
            }
        }
        return 0; // Default value if no number is found
    }

    // Get the command history
    public List<String> getCommandHistory() {
        return commandHistory;
    }

}

import java.util.*;

public class VoiceCommandFollower implements IObserver{
    public List<String> commandHistory = new ArrayList<>();
    public String command;

    public void update(SystemState systemState) {
        this.command = systemState.voiceCommand;
        commandHistory.add(command);

        if (command.toLowerCase().contains("turn on the lights")) {
            systemState.setLightsOn= true;
            System.out.println("Lights are now ON.");
        } else if (command.toLowerCase().contains("turn off the lights")) {
            systemState.setLightsOn= false;
            System.out.println("Lights are now OFF.");
        }  else {
            System.out.println("Command not recognized.");
        }
    }


}

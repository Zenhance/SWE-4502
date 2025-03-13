import java.util.ArrayList;
import java.util.List;

public class VoiceSystem implements IObserver {
    private List<String> commandHistory = new ArrayList<>();
    private String lastAction;

    @Override
    public void update(SystemState state) {
        String command = state.getStateDescription();

        if (command.equals("Turn On Lights")) {
            lastAction = "Processing command: Turn On Lights";
            commandHistory.add(command);
        } else if (command.equals("Turn Off Lights")) {
            lastAction = "Processing command: Turn Off Lights";
            commandHistory.add(command);
        } else {
            lastAction = "Unknown command.";
        }

    }


    public String getLastAction() {
        return lastAction;
    }

    public List<String> getCommandHistory() {
        return commandHistory;
    }
}

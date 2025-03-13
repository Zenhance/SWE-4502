import java.util.ArrayList;
import java.util.List;

public class VoiceCommandSystem implements IObserver {
    private HomeState homeState;
    private String room;
    private List<String> commandHistory;

    public VoiceCommandSystem(HomeState homeState, String room) {
        this.homeState = homeState;
        this.room = room;
        this.commandHistory = new ArrayList<>();
        homeState.registerObserver(this);
    }

    @Override
    public void update(String stateName, Object value) {
        if (stateName.equals("voice-" + room) && value instanceof String) {
            String command = (String) value;
            commandHistory.add(command);
            processCommand(command);
        }
    }

    public void sendCommand(String command) {
        homeState.setState("voice-" + room, command);
    }

    private void processCommand(String command) {
        if (command.equals("turn on lights")) {
            homeState.setState("lights-" + room, true);
        } else if (command.equals("turn off lights")) {
            homeState.setState("lights-" + room, false);
        }
    }

    public List<String> getCommandHistory() {
        return new ArrayList<>(commandHistory);
    }
}
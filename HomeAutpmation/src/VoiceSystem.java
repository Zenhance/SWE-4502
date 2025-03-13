import java.util.ArrayList;
import java.util.List;

public class VoiceSystem implements IObserver {
    private List<String> commandHistory = new ArrayList<>();
    private String lastAction;

    @Override
    public void update(SystemState state) {

    }


    public String getLastAction() {
        return lastAction;
    }

    public List<String> getCommandHistory() {
        return commandHistory;
    }
}

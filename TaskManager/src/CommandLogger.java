import java.util.ArrayList;
import java.util.List;
public class CommandLogger implements Observer {
    private List<String> logHistory = new ArrayList<>();
    @Override
    public void update(String message) {
        logHistory.add(message);
    }
    public List<String> getLogHistory() {
        return logHistory;
    }
}
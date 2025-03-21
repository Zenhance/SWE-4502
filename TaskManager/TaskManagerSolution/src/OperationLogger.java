import java.util.ArrayList;
import java.util.List;

public class OperationLogger {
    private final List<String> logs = new ArrayList<>();

    public void logOperation(Command command) {
        String log = command.getTimestamp() + " - " + command.getDescription() +
                " [" + command.getType() + "]";
        logs.add(log);
    }

    public List<String> getLogs() {
        return new ArrayList<>(logs);
    }

    public int getLogCount()
    {
        return logs.size();
    }
}

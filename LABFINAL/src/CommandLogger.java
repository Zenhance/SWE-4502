import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class CommandLogger {
    private List<String> logs = new ArrayList<>();

    public void log(Command command) {
        logs.add(command.getDescription());
    }

    public List<String> getLogs() {
        return logs;
    }
} //logger //versioned

import java.util.HashMap;
import java.util.Map;

public class StatisticsCollector {
    private Map<String, Integer> commandCounts = new HashMap<>();

    public void track(Command command) {
        commandCounts.put(command.getDescription(), commandCounts.getOrDefault(command.getDescription(), 0) + 1);
    }

    public int getCommandCount(String description) {
        return commandCounts.getOrDefault(description, 0);
    }
}
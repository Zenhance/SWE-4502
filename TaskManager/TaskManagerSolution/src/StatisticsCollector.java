import java.util.EnumMap;
import java.util.Map;

public class StatisticsCollector {
    private final Map<CommandType, Integer> commandCounts = new EnumMap<>(CommandType.class);
    private int issuesCreated = 0;

    public StatisticsCollector() {
        for (CommandType type : CommandType.values()) {
            commandCounts.put(type, 0);
        }
    }

    public void collectStatistics(Command command) {
        CommandType type = command.getType();
        commandCounts.put(type, commandCounts.get(type) + 1);

        if (type == CommandType.CREATE) {
            issuesCreated++;
        }
    }

    public int getCommandCount(CommandType type) {
        return commandCounts.getOrDefault(type, 0);
    }

    public int getIssuesCreated() {
        return issuesCreated;
    }

    public Map<CommandType, Integer> getAllCommandCounts() {
        return new EnumMap<>(commandCounts);
    }
}

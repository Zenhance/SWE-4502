package service;
import command.Command;
import command.CommandType;
import java.util.EnumMap;
import java.util.Map;

public class StatisticsService {
    private final Map<CommandType, Integer> commandCounts = new EnumMap<>(CommandType.class);
    private int totalIssuesCreated = 0;

    public StatisticsService() {
        for (CommandType type : CommandType.values()) {
            commandCounts.put(type, 0);
        }
    }

    public void trackCommand(Command command) {
        CommandType type = command.getType();
        commandCounts.put(type, commandCounts.get(type) + 1);

        if (type == CommandType.Create && command.getDescription().contains("Created issue")) {
            totalIssuesCreated++;
        }
    }

    public int getCommandCount(CommandType type) {
        return commandCounts.getOrDefault(type, 0);
    }

    public int getTotalCommandCount() {
        return commandCounts.values().stream().mapToInt(Integer::intValue).sum();
    }

    public int getTotalIssuesCreated() {
        return totalIssuesCreated;
    }

    public Map<CommandType, Integer> getAllCommandCounts() {
        return new EnumMap<>(commandCounts);
    }
}
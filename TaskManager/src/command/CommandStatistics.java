package command;

import java.util.EnumMap;
import java.util.Map;

public class CommandStatistics {
    private final Map<CommandType, Integer> commandCounts;
    private int totalIssuesCreated;

    public CommandStatistics() {
        commandCounts = new EnumMap<>(CommandType.class);
        for (CommandType type : CommandType.values()) {
            commandCounts.put(type, 0);
        }
        totalIssuesCreated = 0;
    }

    public void incrementCommandCount(CommandType type) {
        commandCounts.put(type, commandCounts.get(type) + 1);
        if (type == CommandType.Create) {
            totalIssuesCreated++;
        }
    }

    public int getCommandCount(CommandType type) {
        return commandCounts.get(type);
    }

    public int getTotalCommandCount() {
        int total = 0;
        for (int count : commandCounts.values()) {
            total += count;
        }
        return total;
    }

    public int getTotalIssuesCreated() {
        return totalIssuesCreated;
    }

    public Map<CommandType, Integer> getCommandCounts() {
        return new EnumMap<>(commandCounts);
    }
}
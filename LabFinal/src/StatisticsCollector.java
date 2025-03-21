import java.util.*;

public class StatisticsCollector {
    private Map<CommandType, Integer> commandCounts = new HashMap<>();
    private int issuesCreated = 0;

    public void increment(CommandType type) {
        commandCounts.put(type, commandCounts.getOrDefault(type, 0) + 1);
        if (type == CommandType.CREATE) issuesCreated++;
    }

    public int getCount(CommandType type) {
        return commandCounts.getOrDefault(type, 0);
    }

    public int getIssuesCreated() {
        return issuesCreated;
    }
}

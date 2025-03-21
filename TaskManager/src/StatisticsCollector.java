import java.util.*;

public class StatisticsCollector {
    private Map<String, Integer> commandCounts = new HashMap<>();

    public void incrementCommandCount(String commandType) {
        commandCounts.put(commandType, commandCounts.getOrDefault(commandType, 0) + 1);
    }

    public void printStatistics() {
        System.out.println("Command Statistics:");
        for (Map.Entry<String, Integer> entry : commandCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

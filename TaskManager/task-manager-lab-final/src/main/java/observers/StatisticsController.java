package observers;

import commands.Command;
import models.CommandType;

import java.util.HashMap;
import java.util.Map;

public class StatisticsController implements Observer{
    private Map<CommandType, Integer> commandCounts = new HashMap<>();

    @Override
    public void update(Command command) {
        CommandType type = command.getType();
        commandCounts.put(type, commandCounts.getOrDefault(type, 0) + 1);
    }

    public Map<CommandType, Integer> getCommandCounts() {
        return new HashMap<>(commandCounts);
    }
}

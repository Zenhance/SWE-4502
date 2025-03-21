package Lab_Final_210042150.Task_Management_System.Services;

import Lab_Final_210042150.Task_Management_System.Enums.commandType;

import java.util.HashMap;
import java.util.Map;

public class StatisticsService {
    private static StatisticsService instance;
    private static Map<commandType,Integer> cmdcounts = new HashMap<>();
    private int issueCreated = 0;

    private StatisticsService()
    {
        for(commandType type : commandType.values())
        {
            cmdcounts.put(type,0);
        }
    }

    public static synchronized StatisticsService getInstance()
    {
        if(instance == null)
        {
            instance = new StatisticsService();
        }
        return instance;
    }

    public void incrementCommandCount(commandType type)
    {
        cmdcounts.put(type,cmdcounts.getOrDefault(type,0)+1);
    }
    public void decrementCommandCount(commandType type)
    {
        cmdcounts.put(type,Math.max(0,cmdcounts.getOrDefault(type,0)-1));
    }

    public int getCommandCount(commandType type)
    {
        return cmdcounts.getOrDefault(type,0);
    }

    public Map<commandType, Integer> getAllCommandCounts() {
        return new HashMap<>(cmdcounts);
    }

    public void incrementIssueCreated() {
        issueCreated++;
    }

    public void decrementIssueCreated() {
        issueCreated = Math.max(0, issueCreated - 1);
    }

    public int getIssuesCreated() {
        return issueCreated;
    }

}

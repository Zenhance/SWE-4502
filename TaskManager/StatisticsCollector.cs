using System.Collections.Generic;

public class StatisticsCollector
{
    private Dictionary<string, int> stats = new();

    public void Track(string commandName)
    {
        if (!stats.ContainsKey(commandName))
            stats[commandName] = 0;
        stats[commandName]++;
    }

    public Dictionary<string, int> GetStatistics() => stats;
}

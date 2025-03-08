import java.util.*;

public class EnergyTracker implements IObserver{
    public List<Double> history = new ArrayList<>();
    public double totalUsage = 0;
    public int count = 0;
    public double averageUsage = 0;

    @Override
    public void update(SystemState state)
    {
        double currentUsage = state.energyUsage;
        usageStatistics(currentUsage);
    }

    private void usageStatistics(double usage) {
        history.add(usage);
        totalUsage += usage;
        count++;
        averageUsage = totalUsage / count;
    }


}

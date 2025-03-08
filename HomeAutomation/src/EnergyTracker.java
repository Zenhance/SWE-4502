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
        detectUnusualConsumption(currentUsage);
    }

    private void usageStatistics(double usage) {
        history.add(usage);
        totalUsage += usage;
        count++;
        averageUsage = totalUsage / count;
    }

    private void detectUnusualConsumption(double currentUsage) {
        if (currentUsage > averageUsage * 2) {
            System.out.println("Unusual high consumption detected.");
        } else if (currentUsage < averageUsage / 2) {
            System.out.println("Unusual low consumption detected.");
        }
    }


}

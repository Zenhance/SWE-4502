import java.util.*;

public class EnergyTracker implements IObserver{
    public List<Double> history = new ArrayList<>();

    @Override
    public void update(SystemState state)
    {
        double currentUsage = state.energyUsage;
    }



}

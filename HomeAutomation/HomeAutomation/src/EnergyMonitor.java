import java.util.ArrayList;
import java.util.List;

public class EnergyMonitor implements Observer {
    private List<Double> usageLog = new ArrayList<>();
    private static final double USAGE_THRESHOLD = 10.0; // kWh for abnormal usage

    @Override
    public void update(String state, Object value) {
        if (state.equals("POWER_USAGE")) {
            double powerUsage = (Double) value;
            usageLog.add(powerUsage);
            System.out.println("EnergyMonitor: Current power usage is " + powerUsage + " kWh");
        }
    }

    public boolean detectUnusualUsage() {
        return usageLog.stream().anyMatch(usage -> usage > USAGE_THRESHOLD);
    }
}

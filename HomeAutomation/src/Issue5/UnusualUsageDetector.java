package Issue5;

import java.util.List;

public class UnusualUsageDetector {
    private static final double THRESHOLD_FACTOR = 2.0;

    public boolean UnusualUse(List<EnergyReading> readings) {
        if (readings.size() < 5) return false;
        double currentUsage = readings.get(readings.size() - 1).getPowerUsage();
        double avg = readings.subList(0, readings.size() - 1)
                .stream()
                .mapToDouble(EnergyReading::getPowerUsage)
                .average()
                .orElse(0);
        return currentUsage > avg * THRESHOLD_FACTOR;
    }
}
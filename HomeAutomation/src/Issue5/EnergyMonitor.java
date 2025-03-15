package Issue5;

import Issue1.StateManager;
import Issue1.IComponent;
import java.time.LocalDateTime;
import java.util.*;

public class EnergyMonitor implements IComponent {
    private final StateManager stateManager;
    private double currentPowerUsage = 0.0;
    private final Map<String, Double> devicePowerUsage = new HashMap<>();
    private final List<EnergyReading> readings = new ArrayList<>();
    private final UnusualUsageDetector unusualUsageDetector;

    public EnergyMonitor(StateManager stateManager) {
        this.stateManager = stateManager;
        this.unusualUsageDetector = new UnusualUsageDetector();
        stateManager.registerComponent("power_usage", this);
        stateManager.registerComponent("device_power", this);
    }

    @Override
    public void onStateChange(String key, Object newValue) {
        if (newValue instanceof Double && key.equals("power_usage")) {
            currentPowerUsage = (Double) newValue;
            recordReading();
        } else if (newValue instanceof DevicePower && key.equals("device_power")) {
            DevicePower device = (DevicePower) newValue;
            devicePowerUsage.put(device.getDeviceId(), device.getPowerUsage());
            updateTotalPowerUsage();
        }
    }

    private void recordReading() {
        readings.add(new EnergyReading(currentPowerUsage, LocalDateTime.now()));
        if (readings.size() % 10 == 0) calculateEnergyStatistics();
        if (readings.size() >= 10 && unusualUsageDetector.UnusualUse(readings)) {
            stateManager.updateState("energy_anomaly", new UnusualUsage("Unusual energy consumption", System.currentTimeMillis()));
        }
    }

    private void updateTotalPowerUsage() {
        currentPowerUsage = devicePowerUsage.values().stream().mapToDouble(Double::doubleValue).sum();
        stateManager.updateState("power_usage", currentPowerUsage);
    }

    private void calculateEnergyStatistics() {
        double avg = readings.stream().mapToDouble(EnergyReading::getPowerUsage).average().orElse(0);
        double peak = readings.stream().mapToDouble(EnergyReading::getPowerUsage).max().orElse(0);
        double cumulative = readings.stream().mapToDouble(EnergyReading::getPowerUsage).sum() / 3600.0;

        stateManager.updateState("energy_statistics", new EnergyStats(avg, peak, cumulative));
    }
}

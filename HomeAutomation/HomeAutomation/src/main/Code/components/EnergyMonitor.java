package main.Code.components;

import core.EventType;
import core.HomeSystem;
import core.HomeSystemObserver;
import java.time.LocalDateTime;
import java.util.Map;

public interface EnergyMonitor extends HomeSystemObserver {
    void recordConsumption(String device, double watts, LocalDateTime timestamp);
    double getCurrentConsumption();
    Map<String, Double> getDeviceConsumption();
    boolean isConsumptionUnusual();
    Map<String, Object> getUsageStatistics();
}

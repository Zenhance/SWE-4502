package Issue5;

import java.time.LocalDateTime;

public class EnergyReading {
    private final double powerUsage;
    private final LocalDateTime timestamp;

    public EnergyReading(double powerUsage, LocalDateTime timestamp) {
        this.powerUsage = powerUsage;
        this.timestamp = timestamp;
    }

    public double getPowerUsage() { return powerUsage; }
    public LocalDateTime getTimestamp() { return timestamp; }
}

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SmartHomeData {
    private static final int HISTORY_LIMIT = 20;
    private final Map<String, Queue<SensorReading>> sensorData;

    public SmartHomeData() {
        sensorData = new HashMap<>();
    }

    public void addReading(String sensorType, double value) {
        sensorData.putIfAbsent(sensorType, new LinkedList<>());
        Queue<SensorReading> readings = sensorData.get(sensorType);
        if (readings.size() >= HISTORY_LIMIT) readings.poll();
        readings.add(new SensorReading(LocalDateTime.now(), value));
    }

    public double getLatestReading(String sensorType) {
        if (!sensorData.containsKey(sensorType) || sensorData.get(sensorType).isEmpty())
            throw new IllegalStateException("No readings available for " + sensorType);
        return sensorData.get(sensorType).peek().value();
    }

    private record SensorReading(LocalDateTime timestamp, double value) {}
}

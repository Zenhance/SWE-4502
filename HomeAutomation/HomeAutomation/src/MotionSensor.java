import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MotionSensor implements Observer {
    private boolean motionDetected = false;
    private List<String> activityLog = new ArrayList<>();

    @Override
    public void update(String state, Object value) {
        if (state.equals("MOTION")) {
            motionDetected = (Boolean) value;
            String logEntry = LocalDateTime.now() + " - Motion detected: " + motionDetected;
            activityLog.add(logEntry);
            System.out.println("Motion Sensor: " + logEntry);
        }
    }

    public List<String> getActivityLog() {
        return activityLog;
    }

    public boolean analyzePatterns() {
        // Basic logic to detect suspicious activity (e.g., motion detected at odd hours)
        long nightActivity = activityLog.stream()
                .filter(log -> log.contains("Motion detected: true") && log.contains("T23") || log.contains("T00") || log.contains("T01"))
                .count();
        return nightActivity > 5; // Flag if motion is detected frequently at night
    }
}

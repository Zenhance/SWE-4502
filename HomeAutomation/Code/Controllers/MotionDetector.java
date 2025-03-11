package Code.Controllers;

import Code.Interfaces.Component;
import Code.StateManagementClasses.StateManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MotionDetector implements Component {
    private StateManager stateManager;
    private List<MotionEvent> motionLog;

    public MotionDetector(StateManager stateManager) {
        this.stateManager = stateManager;
        this.motionLog = new ArrayList<>();
    }

    @Override
    public void onStateChange(String key, Object value) {
        if ("motion".equals(key) && value instanceof Boolean) {
            detectMotion((Boolean) value);
        }
    }

    private void detectMotion(boolean motionDetected) {
        if (motionDetected) {
            LocalDateTime timestamp = LocalDateTime.now();
            String location = "Living Room"; // Placeholder, can be dynamic

            MotionEvent event = new MotionEvent(timestamp, location);
            motionLog.add(event);

            System.out.println("Motion detected at " + location + " on " + timestamp);
            analyzeMotionPatterns();
        }
    }

    private void analyzeMotionPatterns() {
        int motionCount = motionLog.size();
        if (motionCount > 5) { // Example threshold for suspicious activity
            System.out.println("⚠ Suspicious activity detected! Frequent motion events recorded.");
        } else {
            System.out.println("✔ Normal motion activity.");
        }
    }

    public List<MotionEvent> getMotionLog() {
        return motionLog;
    }

    public static class MotionEvent {
        private LocalDateTime timestamp;
        private String location;

        public MotionEvent(LocalDateTime timestamp, String location) {
            this.timestamp = timestamp;
            this.location = location;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        public String getLocation() {
            return location;
        }
    }
}

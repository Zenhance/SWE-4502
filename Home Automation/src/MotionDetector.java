import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MotionDetector implements Observer {
    private static final Logger logger = Logger.getLogger(MotionDetector.class.getName());

    // List to store detected motion events
    private List<MotionEvent> motionHistory = new ArrayList<>();

    // Default location for motion detection
    private String location = "Living Room";

    // Method to update the motion detection status
    @Override
    public void update(String state, Object value) {
        if ("MOTION".equals(state) && value instanceof Boolean) {
            boolean motionDetected = (Boolean) value;
            if (motionDetected) {
                logMotion();
            }
        }
    }

    // Log motion events with timestamp and location
    private void logMotion() {
        long currentTime = System.currentTimeMillis(); // Get the current timestamp
        MotionEvent motionEvent = new MotionEvent(location, currentTime);
        motionHistory.add(motionEvent);

        logger.info("Motion detected in " + location + " at " + currentTime);
    }

    // Analyze motion patterns to detect suspicious behavior
    public boolean isSuspiciousBehavior() {
        long now = System.currentTimeMillis();
        long thresholdTime = now - 60000; // 1 minute threshold
        int motionCount = 0;

        // Count how many motions occurred in the last minute
        for (MotionEvent event : motionHistory) {
            if (event.getTimestamp() >= thresholdTime) {
                motionCount++;
            }
        }

        return motionCount >= 3; // If 3 or more motions in the last minute, it's suspicious
    }

    // Method to get motion history
    public List<MotionEvent> getMotionHistory() {
        return motionHistory;
    }

    // Method to clear motion history (useful for testing or resetting the system)
    public void clearMotionHistory() {
        motionHistory.clear();
    }

    // Inner class to represent a motion event with location and timestamp
    private static class MotionEvent {
        private final String location;
        private final long timestamp;

        public MotionEvent(String location, long timestamp) {
            this.location = location;
            this.timestamp = timestamp;
        }

        public String getLocation() {
            return location;
        }

        public long getTimestamp() {
            return timestamp;
        }
    }
}
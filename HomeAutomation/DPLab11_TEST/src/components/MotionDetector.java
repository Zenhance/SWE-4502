package components;

import java.util.HashMap;
import java.util.Map;

class MotionDetector {
    private Map<String, String> motionLogs;

    public MotionDetector() {
        motionLogs = new HashMap<>();
    }


    public void detectMotion(String location, String time) {
        motionLogs.put(location, time);
    }


    public String getLastLocation() {
        return motionLogs.keySet().stream().findFirst().orElse("Unknown");
    }

    // Get the last detected time
    public String getLastTime() {
        return motionLogs.values().stream().findFirst().orElse("Unknown");  // Return the first logged time
    }

    // Analyze motion patterns to determine if behavior is normal or suspicious
    public boolean analyzeBehavior() {
        // Placeholder analysis logic (for now, always returns true)
        return true;  // Can be expanded with real logic for detecting suspicious behavior
    }

    // Check if motion has been detected
    public boolean isMotionDetected() {
        return !motionLogs.isEmpty();  // Returns true if there are any logged motions
    }
}

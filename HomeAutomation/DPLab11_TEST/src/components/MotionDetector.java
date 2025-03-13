package components;

import core.IComponent;

import java.util.List;
import java.util.ArrayList;

public class MotionDetector implements IComponent {
    private List<String> motionLog;
    private int suspiciousActivityThreshold;

    public MotionDetector() {
        motionLog = new ArrayList<>();
    }

    @Override
    public void onStateChanged(String newState, int value) {
        if (newState == null || newState.trim().isEmpty()) {
            // Log and handle null or empty state as an error
            System.out.println("Received invalid state: State cannot be null or empty.");
            // Optionally, throw an exception
            throw new IllegalArgumentException("State cannot be null or empty.");
        }

        // If the state contains "motion", process it
        if (newState.contains("motion")) {
            logActivity(newState);
            analyzePattern();
        }
    }


    public void setSuspiciousActivityThreshold(int threshold) {
        suspiciousActivityThreshold = threshold;
    }

    public void logActivity(String motionData) {
        motionLog.add(motionData);
    }

    public void analyzePattern() {
        if (motionLog.size() > suspiciousActivityThreshold) {
            System.out.println("Suspicious activity detected! Alerting security.");
        }
    }

    public void trackMovement(String location, String time) {
        System.out.println("Movement detected at " + location + " at " + time);
    }

    public List<String> getMotionLog() {
        return motionLog;
    }
}

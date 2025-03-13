package lab11_210042164.implementation.features;

import lab11_210042164.implementation.interfaces.Component;
import lab11_210042164.implementation.manager.StateManager;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MotionDetector implements Component {
    private StateManager stateManager;
    private List<MotionEvent> motionEvents = new ArrayList<>();
    private boolean motionDetected = false;

    public static class MotionEvent {
        private String location;
        private LocalDateTime timestamp;

        public MotionEvent(String location, LocalDateTime timestamp) {
            this.location = location;
            this.timestamp = timestamp;
        }

        public String getLocation() {
            return location;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }
    }

    public MotionDetector(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    @Override
    public void onStateChange(String key, Object value) {
        if ("motion".equals(key)) {
            processMotionData((String) value);
        }
    }

    private void processMotionData(String location) {
        motionDetected = true;
        MotionEvent event = new MotionEvent(location, LocalDateTime.now());
        motionEvents.add(event);
        System.out.println("Motion detected in " + location + " at " + event.getTimestamp());

        stateManager.updateState("roomOccupancy", location);

        // Analysis logic could be added here
        boolean suspicious = isSuspiciousActivity(location);
        if (suspicious) {
            stateManager.updateState("securityAlert", "Suspicious motion in " + location);
        }
    }

    private boolean isSuspiciousActivity(String location) {
        if (motionEvents.size() < 2) return false;

        MotionEvent lastEvent = motionEvents.get(motionEvents.size() - 1);
        MotionEvent previousEvent = motionEvents.get(motionEvents.size() - 2);

        return !lastEvent.getLocation().equals(previousEvent.getLocation()) &&
                lastEvent.getTimestamp().minusSeconds(5).isBefore(previousEvent.getTimestamp());
    }

    public boolean isMotionDetected() {
        return motionDetected;
    }

    public List<MotionEvent> getMotionHistory() {
        return new ArrayList<>(motionEvents);
    }

    public void resetMotionState() {
        motionDetected = false;
    }
}

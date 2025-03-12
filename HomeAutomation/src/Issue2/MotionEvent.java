package Issue2;

public class MotionEvent {
    private final boolean detected;
    private final String location;
    private final long timestamp;

    public MotionEvent(boolean detected, String location, long timestamp) {
        this.detected = detected;
        this.location = location;
        this.timestamp = timestamp;
    }

    public boolean isDetected() {
        return detected;
    }

    public String getLocation() {
        return location;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
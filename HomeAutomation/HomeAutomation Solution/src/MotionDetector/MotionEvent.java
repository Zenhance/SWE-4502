package MotionDetector;

public class MotionEvent {
    private long timestamp;
    private String location;

    public MotionEvent(long timestamp, String location) {
        this.timestamp = timestamp;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Location: " + location + ", Time: " + timestamp;
    }

    // Getters
    public long getTimestamp() { return timestamp; }
    public String getLocation() { return location; }
}


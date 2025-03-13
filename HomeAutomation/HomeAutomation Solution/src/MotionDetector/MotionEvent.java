package MotionDetector;

import java.time.LocalDateTime;

public class MotionEvent {
    private final String location;
    private final LocalDateTime timestamp;

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

package MotionDetection;

import java.time.LocalDateTime;

// MotionEvent stores details of motion detection
public class MotionEvent {
    private LocalDateTime timestamp;

    public MotionEvent(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}

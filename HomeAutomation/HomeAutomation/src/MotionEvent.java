import java.time.LocalDateTime;

public class MotionEvent {
    public String location;
    public LocalDateTime timestamp;

    public MotionEvent(String location, LocalDateTime timestamp) {
        this.location = location;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "MotionEvent{" +
                "location='" + location + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}

package Issue2;

public class AlarmEvent {
    private final String message;
    private final long timestamp;

    public AlarmEvent(String message, long timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public long getTimestamp() {
        return timestamp;
    }
}

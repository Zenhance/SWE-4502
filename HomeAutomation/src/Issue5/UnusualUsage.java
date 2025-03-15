package Issue5;



public class UnusualUsage {
    private final String message;
    private final long timestamp;

    public UnusualUsage(String message, long timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getMessage() { return message; }
    public long getTimestamp() { return timestamp; }
}


public class MotionEvent {
    private String location;
    private boolean motionDetected;
    private long timestamp;

    public MotionEvent(String location, boolean motionDetected) {
        this.location = location;
        this.motionDetected = motionDetected;
        this.timestamp = System.currentTimeMillis();
    }

    public String getLocation() { return location; }
    public boolean isMotionDetected() { return motionDetected; }
    public long getTimestamp() { return timestamp; }
}
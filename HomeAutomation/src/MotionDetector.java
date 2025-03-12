public class MotionDetector implements IComponent {
    private boolean motionDetected = false;
    private String location = "";
    private long lastMotionTimestamp = 0;
    private final StateManager stateManager;
    private final MotionAnalyzer analyzer;

    public MotionDetector(StateManager stateManager) {
        this.stateManager = stateManager;
        this.analyzer = new MotionAnalyzer();
        this.stateManager.registerComponent("motion", this);
    }

    @Override
    public void onStateChange(String key, Object newValue) {
        if ("motion".equals(key) && newValue instanceof MotionEvent) {
            MotionEvent event = (MotionEvent) newValue;
            this.motionDetected = event.isDetected();
            this.location = event.getLocation();
            this.lastMotionTimestamp = event.getTimestamp();
            logActivity(event);

            boolean suspicious = analyzer.analyzeMotion(event);
            if (suspicious) {
                stateManager.updateState("alarm", new AlarmEvent("Suspicious motion detected in " + location, System.currentTimeMillis()));
            }
        }
    }

    private void logActivity(MotionEvent event) {
        // In a real implementation, this would log to a file or database
        System.out.println("Motion " + (event.isDetected() ? "detected" : "ended") +
                " in " + event.getLocation() + " at " + event.getTimestamp());
    }

    public boolean isMotionDetected() {
        return motionDetected;
    }

    public String getLocation() {
        return location;
    }

    public long getLastMotionTimestamp() {
        return lastMotionTimestamp;
    }
}
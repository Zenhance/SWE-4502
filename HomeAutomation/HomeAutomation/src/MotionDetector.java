import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class MotionDetector implements Observer {
    public List<MotionEvent> motionEvents = new ArrayList<>();
    public String location;

    public MotionDetector(String location) {
        this.location = location;
    }

    @Override
    public void update(EnvironmentState state) {
        if (state.motionDetected) {
            MotionEvent event = new MotionEvent(location, LocalDateTime.now());
            motionEvents.add(event);
            System.out.println("Motion detected at " + event);
        }
    }

    // Analyze patterns for suspicious behavior (e.g., frequent motion at odd hours)
    public boolean isSuspiciousActivity() {
        long suspiciousCount = motionEvents.stream()
                .filter(event -> event.timestamp.getHour() < 6 || event.timestamp.getHour() > 22)
                .count();
        return suspiciousCount > 0;
    }
}

import java.util.ArrayList;
import java.util.List;

public class MotionDetector implements IObserver {
    private HomeState homeState;
    private String location;
    private List<MotionEvent> motionLog;
    private int motionCount;
    private static final int SUSPICIOUS_COUNT = 3;

    public MotionDetector(HomeState homeState, String location) {
        this.homeState = homeState;
        this.location = location;
        this.motionLog = new ArrayList<>();
        this.motionCount = 0;
        this.homeState.registerObserver(this);
    }

    @Override
    public void update(String stateName, Object value) {
        if (stateName.equals("motion-" + location) && value instanceof Boolean) {
            boolean motion = (Boolean) value;
            MotionEvent event = new MotionEvent(location, motion);
            motionLog.add(event);
            if (motion) {
                motionCount++;
                checkSuspicious();
            }
        }
    }

    public void detectMotion(boolean motion) {
        homeState.setState("motion-" + location, motion);
    }

    private void checkSuspicious() {
        if (motionCount > SUSPICIOUS_COUNT) {
            homeState.setState("suspicious-" + location, true);
        } else {
            homeState.setState("suspicious-" + location, false);
        }
    }

    public List<MotionEvent> getMotionLog() {
        return new ArrayList<>(motionLog);
    }

    public boolean isSuspicious() {
        Object status = homeState.getState("suspicious-" + location);
        return status != null && (Boolean) status;
    }
}
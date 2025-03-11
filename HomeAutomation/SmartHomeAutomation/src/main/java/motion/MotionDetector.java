package motion;

import core.Event;
import core.EventListener;
import core.model.EventType;
import core.StateManager;
import core.model.Measurement;

public class MotionDetector implements EventListener {
    private StateManager stateManager;
    private ActivityLog activityLog;
    private boolean motionDetected = false;

    public MotionDetector(StateManager stateManager, ActivityLog activityLog) {
        this.stateManager = stateManager;
        this.activityLog = activityLog;
        stateManager.register(EventType.MOTION, this);
    }

    public void detectMotion(boolean detected) {
        this.motionDetected = detected;
        Measurement measurement = new Measurement(detected ? 1 : 0, Measurement.Units.COUNT);
        stateManager.setState(EventType.MOTION, measurement);
        if (detected) {
            activityLog.logActivity("Motion detected at " + System.currentTimeMillis());
        }
    }

    public boolean isMotionDetected() {
        return motionDetected;
    }

    @Override
    public void onEvent(Event event) {
        if (event.getType() == EventType.MOTION) {
            motionDetected = ((Measurement) event.getData()).getValue() > 0;
        }
    }
}

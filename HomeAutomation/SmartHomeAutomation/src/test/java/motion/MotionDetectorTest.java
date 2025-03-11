package motion;

import core.StateManager;
import core.model.Measurement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MotionDetectorTest {

    @Test
    void testMotionDetectionLogsActivity() {
        StateManager stateManager = new StateManager();
        ActivityLog activityLog = new ActivityLog();
        MotionDetector motionDetector = new MotionDetector(stateManager, activityLog);

        motionDetector.detectMotion(true);

        assertFalse(activityLog.getLog().isEmpty(), "Activity should be logged");
    }

    @Test
    void testMotionDetectedStateIsUpdated() {
        StateManager stateManager = new StateManager();
        ActivityLog activityLog = new ActivityLog();
        MotionDetector motionDetector = new MotionDetector(stateManager, activityLog);

        motionDetector.detectMotion(true);

        assertTrue(motionDetector.isMotionDetected(), "Motion should be detected");

        motionDetector.detectMotion(false);

        assertFalse(motionDetector.isMotionDetected(), "Motion should not be detected");
    }

    @Test
    void testOnEventUpdatesMotionState() {
        StateManager stateManager = new StateManager();
        ActivityLog activityLog = new ActivityLog();
        MotionDetector motionDetector = new MotionDetector(stateManager, activityLog);

        Measurement measurement = new Measurement(1, Measurement.Units.COUNT);
        stateManager.setState(core.model.EventType.MOTION, measurement);

        assertTrue(motionDetector.isMotionDetected(), "Motion should be detected after event");

        measurement = new Measurement(0, Measurement.Units.COUNT);
        stateManager.setState(core.model.EventType.MOTION, measurement);

        assertFalse(motionDetector.isMotionDetected(), "Motion should not be detected after event");
    }
}

package Test;

import org.junit.jupiter.api.Test;
import Code.StateManagementClasses.StateManager;
import Code.Controllers.MotionDetector;

import static org.junit.jupiter.api.Assertions.*;

class MotionDetectorTest {

    @Test
    void testNormalMotion() {
        StateManager stateManager = new StateManager();
        MotionDetector motionDetector = new MotionDetector(stateManager);

        for (int i = 0; i < 3; i++) {
            motionDetector.onStateChange("motion", true);
        }

        assertTrue(motionDetector.getMotionLog().size() <= 5, "Should be normal motion activity.");
    }

    @Test
    void testSuspiciousMotion() {
        StateManager stateManager = new StateManager();
        MotionDetector motionDetector = new MotionDetector(stateManager);

        for (int i = 0; i < 6; i++) {
            motionDetector.onStateChange("motion", true);
        }

        assertTrue(motionDetector.getMotionLog().size() > 5, "Should detect suspicious activity.");
    }

    @Test
    void testInvalidKey() {
        StateManager stateManager = new StateManager();
        MotionDetector motionDetector = new MotionDetector(stateManager);

        motionDetector.onStateChange("invalidKey", true);

        assertEquals(0, motionDetector.getMotionLog().size(), "Invalid key should not log motion.");
    }
}
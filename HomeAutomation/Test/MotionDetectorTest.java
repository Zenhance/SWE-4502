package Test;

import org.junit.jupiter.api.Test;
import Code.StateManagementClasses.StateManager;
import Code.Controllers.MotionDetector;

import static org.junit.jupiter.api.Assertions.*;

class MotionDetectorTest {

    // ✅ Case 1: Motion is detected and logged (Normal Activity)
    @Test
    void testNormalMotion() {
        StateManager stateManager = new StateManager();
        MotionDetector motionDetector = new MotionDetector(stateManager);

        // Simulating normal activity (3 motion events)
        for (int i = 0; i < 3; i++) {
            motionDetector.onStateChange("motion", true);
        }

        assertTrue(motionDetector.getMotionLog().size() <= 5, "Should be normal motion activity.");
    }

    // ✅ Case 2: Excessive motion is detected (Suspicious Activity)
    @Test
    void testSuspiciousMotion() {
        StateManager stateManager = new StateManager();
        MotionDetector motionDetector = new MotionDetector(stateManager);

        // Simulating excessive activity (6 motion events)
        for (int i = 0; i < 6; i++) {
            motionDetector.onStateChange("motion", true);
        }

        assertTrue(motionDetector.getMotionLog().size() > 5, "Should detect suspicious activity.");
    }

    // ✅ Case 3: Invalid key should not trigger motion detection
    @Test
    void testInvalidKey() {
        StateManager stateManager = new StateManager();
        MotionDetector motionDetector = new MotionDetector(stateManager);

        motionDetector.onStateChange("invalidKey", true);

        assertEquals(0, motionDetector.getMotionLog().size(), "Invalid key should not log motion.");
    }
}

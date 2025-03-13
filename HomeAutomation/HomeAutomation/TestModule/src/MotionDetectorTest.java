import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MotionDetectorTest {

    private MotionDetector motionDetector;

    @BeforeEach
    void setUp() {
        motionDetector = new MotionDetector();
    }

    @Test
    void testMotionDetection() {
        // Simulate motion detection event
        boolean motionDetected = true;
        // Directly call the update method on MotionDetector
        motionDetector.update("MOTION", motionDetected);

        // Assert that the MotionDetector logs the motion
        assertFalse(motionDetector.getMotionHistory().isEmpty(), "Motion should be logged.");
    }

    @Test
    void testNoMotionDetected() {
        // Simulate no motion detected
        boolean motionDetected = false;
        // Directly call the update method on MotionDetector
        motionDetector.update("MOTION", motionDetected);

        // Assert that no motion events are logged
        assertTrue(motionDetector.getMotionHistory().isEmpty(), "No motion should be logged.");
    }

    @Test
    void testSuspiciousBehavior() throws InterruptedException {
        // Simulate multiple motion events in a short time (less than a minute)
        boolean motionDetected = true;

        // Simulate 3 motions within 1 minute (we use Thread.sleep to simulate time passing)
        for (int i = 0; i < 3; i++) {
            motionDetector.update("MOTION", motionDetected); // Call update directly
            Thread.sleep(1000);  // Sleep for 1 second between motions to simulate quick successive movements
        }

        // Assert that the motion detector identifies suspicious behavior
        assertTrue(motionDetector.isSuspiciousBehavior(), "Behavior should be flagged as suspicious.");
    }

    @Test
    void testNormalBehavior() throws InterruptedException {
        // Simulate motion detection at different intervals (should not be suspicious)
        boolean motionDetected = true;

        // Simulate 2 motions over time (should not be suspicious)
        motionDetector.update("MOTION", motionDetected); // Call update directly
        Thread.sleep(1000); // Sleep for 1 second

        motionDetector.update("MOTION", motionDetected); // Call update directly

        // Assert that the motion detector does not flag suspicious behavior
        assertFalse(motionDetector.isSuspiciousBehavior(), "Behavior should not be flagged as suspicious.");
    }

    @Test
    void testClearMotionHistory() {
        // Simulate motion detection
        boolean motionDetected = true;

        motionDetector.update("MOTION", motionDetected); // Call update directly
        assertFalse(motionDetector.getMotionHistory().isEmpty(), "Motion should be logged.");

        // Clear the motion history
        motionDetector.clearMotionHistory();

        // Assert that the motion history is cleared
        assertTrue(motionDetector.getMotionHistory().isEmpty(), "Motion history should be cleared.");
    }
}

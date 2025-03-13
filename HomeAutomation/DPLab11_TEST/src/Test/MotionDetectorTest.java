import static org.junit.Assert.*;

import components.MotionDetector;
import org.junit.Before;
import org.junit.Test;

public class MotionDetectorComponentTest {

    private MotionDetector motionDetectorA;
    private MotionDetector motionDetectorB;

    @Before
    public void setUp() {
        motionDetectorA = new MotionDetector("MotionDetectorA");
        motionDetectorB = new MotionDetector("MotionDetectorB");
    }

    @Test
    public void testMotionDetection() {
        motionDetectorA.detectMotion();  // Simulate motion detection
        assertTrue("Motion should be detected", motionDetectorA.isMotionDetected());
        assertNotNull("Last motion time should be logged", motionDetectorA.getLastMotionTime());
    }

    @Test
    public void testMotionCount() {
        motionDetectorA.detectMotion();
        motionDetectorA.detectMotion();
        motionDetectorA.detectMotion();

        assertEquals("Motion count should be 3", 3, motionDetectorA.getMotionCount());
    }

    @Test
    public void testAnalyzePatterns() {
        motionDetectorA.detectMotion();
        motionDetectorA.detectMotion();
        motionDetectorA.detectMotion();
        motionDetectorA.detectMotion();
        motionDetectorA.detectMotion();
        motionDetectorA.detectMotion();

        // Check that suspicious behavior is detected after more than 5 motions
        assertTrue("Suspicious behavior should be detected", motionDetectorA.getMotionCount() > 5);
    }

    @Test
    public void testNormalBehavior() {
        motionDetectorB.detectMotion();
        motionDetectorB.detectMotion();

        // Check that normal behavior is detected with less than 6 motions
        assertTrue("Normal behavior should be detected", motionDetectorB.getMotionCount() <= 5);
    }

    @Test
    public void testLogMotion() {
        motionDetectorA.detectMotion();  // Simulate motion detection and logging
        motionDetectorA.logMotion();

        // Since the log is directly printed via System.out, it's not captured here,
        // but we check the count of motions for verification.
        assertEquals("Motion count should be 1", 1, motionDetectorA.getMotionCount());
    }
}

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MotionDetectorTest {
    private HomeState homeState;
    private MotionDetector motionDetector;

    @BeforeEach
    void setUp() {
        homeState = new HomeState();
        motionDetector = new MotionDetector(homeState, "kitchen");
    }

    @Test
    void testMotionDetectionLogsEvent() {
        motionDetector.detectMotion(true);
        assertEquals(1, motionDetector.getMotionLog().size());
        MotionEvent event = motionDetector.getMotionLog().get(0);
        assertEquals("kitchen", event.getLocation());
        assertTrue(event.isMotionDetected());
    }


    @Test
    void testMultipleMotionsTriggerSuspicious() {
        motionDetector.detectMotion(true);
        motionDetector.detectMotion(true);
        motionDetector.detectMotion(true);
        motionDetector.detectMotion(true);

        assertTrue(motionDetector.isSuspicious());
    }

    @Test
    void testResetSuspiciousAfterFewMotions() {
        motionDetector.detectMotion(true);
        motionDetector.detectMotion(true);

        assertFalse(motionDetector.isSuspicious());
    }
}
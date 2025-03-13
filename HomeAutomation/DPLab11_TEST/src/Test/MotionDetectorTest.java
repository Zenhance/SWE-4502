package Test;

import components.MotionDetector;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MotionDetectorTest {

    @Test
    void testOnStateChanged() {
        MotionDetector motionDetector = new MotionDetector();
        motionDetector.setSuspiciousActivityThreshold(5);
        motionDetector.onStateChanged("motion detected", 0);
        assertTrue(motionDetector != null);
    }

    @Test
    void testLogActivity() {
        MotionDetector motionDetector = new MotionDetector();
        motionDetector.logActivity("motion detected at 10:00 AM");
        assertEquals(1, motionDetector.motionLog.size());
    }

    @Test
    void testAnalyzePattern() {
        MotionDetector motionDetector = new MotionDetector();
        motionDetector.setSuspiciousActivityThreshold(2);
        motionDetector.logActivity("motion detected at 10:00 AM");
        motionDetector.logActivity("motion detected at 10:05 AM");
        motionDetector.analyzePattern();
        assertTrue(motionDetector.motionLog.size() > 2);
    }
}

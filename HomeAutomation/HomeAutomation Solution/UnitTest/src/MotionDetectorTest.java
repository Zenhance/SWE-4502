import CoreFramework.HomeEnvironment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import MotionDetector.MotionDetector;
import MotionDetector.MotionEvent;


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class MotionDetectorTest {
    private MotionDetector motionDetector;
    private HomeEnvironment homeEnvironment;

    @BeforeEach
    void setUp() {
        homeEnvironment = HomeEnvironment.getInstance();
        motionDetector = new MotionDetector();
    }

    @Test
    void testDetectMotion() {
        motionDetector.detectMotion();
        List<MotionEvent> events = motionDetector.getMotionEvents();

        assertFalse(events.isEmpty(), "Motion event list should not be empty after detection");
        assertEquals("Living Room", events.get(0).getLocation(), "Motion event should be recorded in the correct location");
    }

    @Test
    void testMotionEventTriggeredByUpdate() {
        homeEnvironment.setState("motion", true);
        List<MotionEvent> events = motionDetector.getMotionEvents();

        assertFalse(events.isEmpty(), "Motion event should be logged when motion is detected");
    }

    @Test
    void testAnalyzePattern() {
        // Simulating multiple motion events
        motionDetector.detectMotion();
        motionDetector.detectMotion();
        motionDetector.detectMotion();
        motionDetector.detectMotion(); // This should trigger pattern analysis

        assertTrue(motionDetector.getMotionEvents().size() > 3, "Motion pattern analysis should be triggered when more than 3 events occur");
    }
}


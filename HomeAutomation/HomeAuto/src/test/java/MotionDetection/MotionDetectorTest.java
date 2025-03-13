package MotionDetection;

import Core.HomeEnvironment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MotionDetectorTest {
    private MotionDetector motionDetector;
    private HomeEnvironment homeEnvironment;

    @BeforeEach
    void setUp() {
        motionDetector = new MotionDetector();
        homeEnvironment = HomeEnvironment.getInstance();
        homeEnvironment.registerObserver("motionEvent", motionDetector); // Register the motionDetector for "motionEvent"
    }

    @Test
    void testMotionDetection() {
        // Simulate a motion event
        homeEnvironment.setState("motionEvent", true);

        // Verify that the motion was detected
        assertTrue(motionDetector.isMotionDetected(), "Motion should be detected.");
    }

    @Test
    void testLogMotion() {
        // Simulate motion detection
        homeEnvironment.setState("motionEvent", true);

        // Check the motion logs
        List<MotionDetector.MotionLogEntry> logs = motionDetector.getMotionLogs();

        assertEquals(1, logs.size(), "There should be one log entry.");
        assertNotNull(logs.get(0).getTimestamp(), "Timestamp should not be null.");
        assertEquals("Living Room", logs.get(0).getLocation(), "Location should be 'Living Room'.");
    }

    @Test
    void testSuspiciousBehaviorDetection() {
        // Simulate motion events with a timestamp in the last 5 minutes
        for (int i = 0; i < 5; i++) {
            homeEnvironment.setState("motionEvent", true);
        }

        // Check if the behavior is detected as suspicious (should be based on threshold of 5 motion events in 5 minutes)
        assertTrue(motionDetector.isSuspicious(), "Behavior should be detected as suspicious.");
    }

    @Test
    void testNormalBehaviorDetection() {
        // Simulate fewer than 5 motion events in a short time
        for (int i = 0; i < 4; i++) {
            homeEnvironment.setState("motionEvent", true);
        }

        // Check if the behavior is detected as not suspicious
        assertFalse(motionDetector.isSuspicious(), "Behavior should not be detected as suspicious.");
    }

    @Test
    void testMotionLogAfterMultipleEvents() {
        // Simulate multiple motion events
        homeEnvironment.setState("motionEvent", true);
        homeEnvironment.setState("motionEvent", true);

        List<MotionDetector.MotionLogEntry> logs = motionDetector.getMotionLogs();
        assertEquals(2, logs.size(), "There should be two log entries.");
    }

    @Test
    void testSuspiciousBehaviorWithEdgeCase() {
        // Simulate 5 motion events but the last event happens exactly at the edge of the 5-minute window
        for (int i = 0; i < 5; i++) {
            homeEnvironment.setState("motionEvent", true);
        }

        // Check if the behavior is detected as suspicious
        assertTrue(motionDetector.isSuspicious(), "Behavior should be detected as suspicious after the threshold is crossed.");
    }
}

package com.homeautomation.components;

import com.homeautomation.core.EnvironmentalState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MotionDetectorTest {
    private MotionDetector motionDetector;
    private EnvironmentalState state;

    @BeforeEach
    void setUp() {
        motionDetector = new MotionDetector();
        state = new EnvironmentalState();
    }

    @Test
    void testMotionDetection() {
        state.setMotionDetected(true);
        state.setMotionLocation("Living Room");

        motionDetector.updateState(state);

        assertTrue(motionDetector.isMotionDetected());
        assertEquals("Living Room", motionDetector.getLastDetectedLocation());
    }

    @Test
    void testNoMotionDetected() {
        state.setMotionDetected(false);
        state.setMotionLocation("None");

        motionDetector.updateState(state);

        assertFalse(motionDetector.isMotionDetected());
        assertEquals("None", motionDetector.getLastDetectedLocation());
    }
}

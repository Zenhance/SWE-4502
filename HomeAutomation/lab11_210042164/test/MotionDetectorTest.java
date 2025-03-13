package lab11_210042164.test;

import lab11_210042164.implementation.features.MotionDetector;
import lab11_210042164.implementation.manager.StateManager;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MotionDetectorTest {

    private MockStateManager mockStateManager;
    private MotionDetector motionDetector;

    // Manual mock for StateManager
    private class MockStateManager extends StateManager {
        private Map<String, Object> updatedStates = new HashMap<>();

        public void updateState(String key, Object value) {
            updatedStates.put(key, value);
            super.updateState(key, value);
        }

        public boolean wasStateUpdated(String key) {
            return updatedStates.containsKey(key);
        }

        public Object getUpdatedStateValue(String key) {
            return updatedStates.get(key);
        }

        public void clearUpdatedStates() {
            updatedStates.clear();
        }
    }

    @Before
    public void setUp() {
        mockStateManager = new MockStateManager();
        motionDetector = new MotionDetector(mockStateManager);
    }

    @Test
    public void testMotionDetection() {
        // Test initial state
        assertFalse(motionDetector.isMotionDetected());
        assertEquals(0, motionDetector.getMotionHistory().size());

        // Simulate motion detection
        motionDetector.onStateChange("motion", "LivingRoom");

        // Verify state changes
        assertTrue(motionDetector.isMotionDetected());
        assertEquals(1, motionDetector.getMotionHistory().size());
        assertEquals("LivingRoom", motionDetector.getMotionHistory().get(0).getLocation());

        // Verify state manager was updated
        assertTrue(mockStateManager.wasStateUpdated("roomOccupancy"));
        assertEquals("LivingRoom", mockStateManager.getUpdatedStateValue("roomOccupancy"));
    }

    @Test
    public void testMultipleMotionEvents() {
        // Simulate multiple motion events
        motionDetector.onStateChange("motion", "LivingRoom");
        motionDetector.onStateChange("motion", "Kitchen");

        // Verify history is maintained correctly
        assertEquals(2, motionDetector.getMotionHistory().size());
        assertEquals("LivingRoom", motionDetector.getMotionHistory().get(0).getLocation());
        assertEquals("Kitchen", motionDetector.getMotionHistory().get(1).getLocation());
    }

    @Test
    public void testResetMotionState() {
        // Simulate motion
        motionDetector.onStateChange("motion", "LivingRoom");
        assertTrue(motionDetector.isMotionDetected());

        // Reset motion state
        motionDetector.resetMotionState();

        // Verify state is reset but history remains
        assertFalse(motionDetector.isMotionDetected());
        assertEquals(1, motionDetector.getMotionHistory().size());
    }

    @Test
    public void testIgnoreIrrelevantStateChanges() {
        // Send an irrelevant state change
        motionDetector.onStateChange("temperature", 22.5);

        // Verify detector didn't react
        assertFalse(motionDetector.isMotionDetected());
        assertEquals(0, motionDetector.getMotionHistory().size());
    }
}
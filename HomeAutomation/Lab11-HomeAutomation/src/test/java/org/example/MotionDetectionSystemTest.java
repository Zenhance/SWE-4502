package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import smarthome.core.*;
import smarthome.components.*;
import java.time.LocalDateTime;
import java.lang.reflect.Field;
import java.util.List;

public class MotionDetectionSystemTest {

    @Mock
    private HomeSystem mockHomeSystem;

    private MotionDetectionSystem motionSystem;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        // Verify the observer registration happened
        motionSystem = new MotionDetectionSystem(mockHomeSystem);
        Mockito.verify(mockHomeSystem).registerObserver("motion", motionSystem);
    }

    @Test
    public void testMotionDetectionWithLocation() {
        // Set up the home system to return a location when motion is detected
        Mockito.when(mockHomeSystem.getStateValue("currentRoom")).thenReturn("livingRoom");

        // Trigger motion detection
        motionSystem.onStateChange("motion", false, true);

        // We need to use reflection to access the private motionEvents list
        try {
            Field eventsField = MotionDetectionSystem.class.getDeclaredField("motionEvents");
            eventsField.setAccessible(true);
            List<?> events = (List<?>) eventsField.get(motionSystem);

            // Verify an event was recorded
            assertEquals(1, events.size());
        } catch (Exception e) {
            fail("Failed to access motion events: " + e.getMessage());
        }
    }

    @Test
    public void testNoMotionDetectionForNonBooleanValues() {
        // This should not trigger motion recording
        motionSystem.onStateChange("motion", null, "active");

        // Check that no motion was recorded
        try {
            Field eventsField = MotionDetectionSystem.class.getDeclaredField("motionEvents");
            eventsField.setAccessible(true);
            List<?> events = (List<?>) eventsField.get(motionSystem);

            // Verify no event was recorded
            assertEquals(0, events.size());
        } catch (Exception e) {
            fail("Failed to access motion events: " + e.getMessage());
        }
    }

    @Test
    public void testNoMotionDetectionForFalseValue() {
        // This should not trigger motion recording
        motionSystem.onStateChange("motion", true, false);

        // Check that no motion was recorded
        try {
            Field eventsField = MotionDetectionSystem.class.getDeclaredField("motionEvents");
            eventsField.setAccessible(true);
            List<?> events = (List<?>) eventsField.get(motionSystem);

            // Verify no event was recorded
            assertEquals(0, events.size());
        } catch (Exception e) {
            fail("Failed to access motion events: " + e.getMessage());
        }
    }

    @Test
    public void testRecordMotionDirectMethod() {
        // Test the direct method for recording motion
        motionSystem.recordMotion("entrance");

        // Check that motion was recorded
        try {
            Field eventsField = MotionDetectionSystem.class.getDeclaredField("motionEvents");
            eventsField.setAccessible(true);
            List<?> events = (List<?>) eventsField.get(motionSystem);

            // Verify an event was recorded
            assertEquals(1, events.size());

            // The event should be for the entrance
            Field locationField = events.get(0).getClass().getDeclaredField("location");
            locationField.setAccessible(true);
            assertEquals("entrance", locationField.get(events.get(0)));
        } catch (Exception e) {
            fail("Failed to access motion events: " + e.getMessage());
        }
    }
}
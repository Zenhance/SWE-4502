package test;

import components.*;
import core.CoreSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class EdgeCaseTest {

    @Test
    public void testInvalidStateInput() {
        CoreSystem coreSystem = CoreSystem.getInstance();

        // Create components and register them
        MotionDetector motionDetector = new MotionDetector();
        coreSystem.registerComponent(motionDetector);

        // Test invalid state (e.g., malformed state input)
        assertThrows(IllegalArgumentException.class, () -> {
            coreSystem.updateState("motion detected in living ro0m"); // Invalid state format
        });
    }

    @Test
    public void testEmptyStateInput() {
        CoreSystem coreSystem = CoreSystem.getInstance();

        // Create components and register them
        LightManager lightManager = new LightManager();
        coreSystem.registerComponent(lightManager);

        // Test empty state input
        assertThrows(IllegalArgumentException.class, () -> {
            coreSystem.updateState(""); // Empty state should be handled gracefully
        });
    }

    @Test
    public void testNullStateInput() {
        CoreSystem coreSystem = CoreSystem.getInstance();

        // Create components and register them
        VoiceCommandProcessor voiceCommandProcessor = new VoiceCommandProcessor();
        coreSystem.registerComponent(voiceCommandProcessor);

        // Test null state input
        assertThrows(IllegalArgumentException.class, () -> {
            coreSystem.updateState(null); // Null state should be handled gracefully
        });
    }
}

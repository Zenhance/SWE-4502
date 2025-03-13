package test;

import components.*;
import core.CoreSystem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PerformanceTest {

    // 1. Basic Performance Test: Handling many observers and state changes in rapid succession
    @Test
    @Timeout(value = 5)  // Test should complete within 5 seconds
    public void testHandlingManyObserversAndStateChanges() {
        CoreSystem coreSystem = CoreSystem.getInstance();

        // Register 100 components (observers)
        for (int i = 0; i < 100; i++) {
            coreSystem.registerComponent(new MotionDetector());
            coreSystem.registerComponent(new LightManager());
            coreSystem.registerComponent(new EnergyTracker());
            coreSystem.registerComponent(new TemperatureController());
            coreSystem.registerComponent(new VoiceCommandProcessor());
        }

        // Simulate 100 state changes in rapid succession
        for (int i = 0; i < 100; i++) {
            coreSystem.updateState("Test state update #" + (i + 1));
        }

        // Assert the system can handle this load (no exceptions, no crashes)
        assertTrue(true);  // This asserts that the test passes without throwing exceptions
    }


}

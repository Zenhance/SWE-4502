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

    // 2. Stress Test: Test with more observers and state changes (e.g., 500 observers)
    @Test
    @Timeout(value = 10)  // Test should complete within 10 seconds
    public void testStressTestWithMoreObservers() {
        CoreSystem coreSystem = CoreSystem.getInstance();

        // Register 500 components (observers)
        for (int i = 0; i < 500; i++) {
            coreSystem.registerComponent(new MotionDetector());
            coreSystem.registerComponent(new LightManager());
            coreSystem.registerComponent(new EnergyTracker());
            coreSystem.registerComponent(new TemperatureController());
            coreSystem.registerComponent(new VoiceCommandProcessor());
        }

        // Simulate 500 state changes in rapid succession
        for (int i = 0; i < 500; i++) {
            coreSystem.updateState("Test state update #" + (i + 1));
        }

        // Assert the system can handle this large number of components and state changes
        assertTrue(true);
    }

    // 3. Timing Performance Test: Measure the time taken to process 1000 state changes
    @Test
    @Timeout(value = 10)  // Test should complete within 10 seconds
    public void testTimingPerformanceFor1000StateChanges() {
        CoreSystem coreSystem = CoreSystem.getInstance();

        // Register 100 components (observers)
        for (int i = 0; i < 100; i++) {
            coreSystem.registerComponent(new MotionDetector());
            coreSystem.registerComponent(new LightManager());
            coreSystem.registerComponent(new EnergyTracker());
            coreSystem.registerComponent(new TemperatureController());
            coreSystem.registerComponent(new VoiceCommandProcessor());
        }

        // Measure the time taken to process 1000 state changes
        long startTime = System.currentTimeMillis();

        // Simulate 1000 state changes
        for (int i = 0; i < 1000; i++) {
            coreSystem.updateState("Test state update #" + (i + 1));
        }

        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;

        System.out.println("Time taken to process 1000 state changes: " + timeTaken + " ms");

        // Ensure the system processes the changes within an acceptable time (e.g., under 5 seconds)
        assertTrue(timeTaken < 5000, "Performance test failed: Took too long to process 1000 state changes.");
    }

    // 4. Performance Test with Timeout: Ensuring the system completes within a time limit
    @Test
    @Timeout(value = 5)  // Ensure test completes within 5 seconds
    public void testPerformanceWithTimeout() {
        CoreSystem coreSystem = CoreSystem.getInstance();

        // Register 200 components (observers)
        for (int i = 0; i < 200; i++) {
            coreSystem.registerComponent(new MotionDetector());
            coreSystem.registerComponent(new LightManager());
            coreSystem.registerComponent(new EnergyTracker());
            coreSystem.registerComponent(new TemperatureController());
            coreSystem.registerComponent(new VoiceCommandProcessor());
        }

        // Simulate 200 state changes in rapid succession
        for (int i = 0; i < 200; i++) {
            coreSystem.updateState("Test state update #" + (i + 1));
        }

        // Assert the test completes within the time limit (5 seconds)
        assertTrue(true);  // Simply passing ensures the test runs within the timeout
    }


}

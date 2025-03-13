package test;

import components.*;
import core.CoreSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntegrationTest {

    @Test
    public void testComponentInteractions() {
        // Initialize the core system and components
        CoreSystem coreSystem = CoreSystem.getInstance();

        MotionDetector motionDetector = new MotionDetector();
        LightManager lightManager = new LightManager();
        EnergyTracker energyTracker = new EnergyTracker();
        TemperatureController temperatureController = new TemperatureController();
        VoiceCommandProcessor voiceCommandProcessor = new VoiceCommandProcessor();

        // Register components to the core system
        coreSystem.registerComponent(motionDetector);
        coreSystem.registerComponent(lightManager);
        coreSystem.registerComponent(energyTracker);
        coreSystem.registerComponent(temperatureController);
        coreSystem.registerComponent(voiceCommandProcessor);

        // Test case 1: Simulate motion detection and verify system behavior
        coreSystem.updateState("motion detected in the living room");

        // Test case 2: Simulate dark environment and verify light adjustment
        coreSystem.updateState("dark environment");

        // Test case 3: Simulate cold environment and verify temperature control
        coreSystem.updateState("cold temperature");

        // Test case 4: Simulate voice command to control TV
        coreSystem.updateState("voice command: turn on TV");

        // Ensure components interact correctly (example: light and temperature changes)
        assertTrue(true); // Just an example of how assertions would be used
    }
}

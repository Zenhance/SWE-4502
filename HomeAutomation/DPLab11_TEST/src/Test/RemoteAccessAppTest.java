package test;

import components.*;
import core.CoreSystem;
import remote.RemoteAccessApp;

public class RemoteAccessAppTest {

    public static void main(String[] args) {
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

        // Test case 1: Simulate "motion detected" state
        System.out.println("Test Case 1: Simulate motion detection");
        coreSystem.updateState("motion detected in the living room");

        // Test case 2: Simulate "dark environment" state
        System.out.println("Test Case 2: Simulate dark environment");
        coreSystem.updateState("dark environment");

        // Test case 3: Simulate "cold temperature" state
        System.out.println("Test Case 3: Simulate cold temperature");
        coreSystem.updateState("cold temperature");

        // Test case 4: Simulate voice command for turning on TV
        System.out.println("Test Case 4: Simulate voice command to turn on TV");
        coreSystem.updateState("voice command: turn on TV");
    }
}

package remote;

import components.*;
import core.CoreSystem;

public class RemoteAccessApp {

    public static void main(String[] args) {
        // Create instances of components
        CoreSystem coreSystem = CoreSystem.getInstance();

        MotionDetector motionDetector = new MotionDetector();
        LightManager lightManager = new LightManager();
        EnergyTracker energyTracker = new EnergyTracker();
        TemperatureController temperatureController = new TemperatureController();
        VoiceCommandProcessor voiceCommandProcessor = new VoiceCommandProcessor();

        // Register components with the CoreSystem
        coreSystem.registerComponent(motionDetector);
        coreSystem.registerComponent(lightManager);
        coreSystem.registerComponent(energyTracker);
        coreSystem.registerComponent(temperatureController);
        coreSystem.registerComponent(voiceCommandProcessor);

        // Simulate changes in the environment state
        System.out.println("Initial State:");
        coreSystem.updateState("motion detected in the living room");
        coreSystem.updateState("motion detected in the backyard");
        coreSystem.updateState("dark environment");
        coreSystem.updateState("cold temperature");
        coreSystem.updateState("voice command: turn on TV");

        // Display notifications based on new states
        System.out.println("\nNotifications based on new state:");
        lightManager.onStateChanged("dark environment", 0); // Example of light manager response
        temperatureController.onStateChanged("cold temperature", 0); // Example of temperature controller response
        voiceCommandProcessor.onStateChanged("voice command: turn on TV", 0); // Example of voice command processor response
    }
}

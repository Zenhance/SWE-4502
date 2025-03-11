package remote;
import components.*;
import core.StateManager;

public class RemoteAccessApp
{
    public static void main(String[] args) {
        StateManager stateManager = StateManager.getInstance();

        MotionDetector motionDetector = new MotionDetector();
        LightManager lightManager = new LightManager();
        EnergyTracker energyTracker = new EnergyTracker();
        TemperatureController temperatureController = new TemperatureController();
        VoiceCommandProcessor voiceCommandProcessor = new VoiceCommandProcessor();

        stateManager.registerSensor(motionDetector);
        stateManager.registerSensor(lightManager);
        stateManager.registerSensor(temperatureController);
        stateManager.registerSensor(energyTracker);
        stateManager.registerSensor(voiceCommandProcessor);

        stateManager.updateState("motion detected in the living room");
        stateManager.updateState("motion detected in the backyard");
        stateManager.updateState("dark environment");
        stateManager.updateState("cold temperature");
        stateManager.updateState("voice command: turn on TV");
    }

}

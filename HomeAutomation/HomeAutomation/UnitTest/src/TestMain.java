import org.junit.jupiter.api.Test;
import core.StateManager;
import components.MotionDetector;
import components.LightManager;
import components.TemperatureController;
import components.EnergyTracker;
import components.VoiceCommandProcessor;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
public class TestMain
{
        private StateManager stateManager;
        private ByteArrayOutputStream outputStream;

        @BeforeEach
        void setUp() {
            stateManager = StateManager.getInstance();
            outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));
        }

        @Test
        void testMotionDetector() {
            MotionDetector motionDetector = new MotionDetector();
            stateManager.registerSensor(motionDetector);

            stateManager.updateState("motion detected in the living room");

            assertTrue(outputStream.toString().contains("Motion detected! Logged: motion detected in the living room"));
        }

        @Test
        void testLightManager() {
            LightManager lightManager = new LightManager();
            stateManager.registerSensor(lightManager);

            stateManager.updateState("dark environment");

            assertTrue(outputStream.toString().contains("It's dark. Turning on lights."));
        }

        @Test
        void testTemperatureControllerCold() {
            TemperatureController temperatureController = new TemperatureController();
            stateManager.registerSensor(temperatureController);

            stateManager.updateState("cold temperature");

            assertTrue(outputStream.toString().contains("It's cold. Turning on heating."));
        }

        @Test
        void testTemperatureControllerHot() {
            TemperatureController temperatureController = new TemperatureController();
            stateManager.registerSensor(temperatureController);

            stateManager.updateState("hot temperature");

            assertTrue(outputStream.toString().contains("It's hot. Turning on cooling."));
        }

        @Test
        void testEnergyTracker() {
            EnergyTracker energyTracker = new EnergyTracker();
            stateManager.registerSensor(energyTracker);

            stateManager.updateState("high energy usage");

            assertTrue(outputStream.toString().contains("Monitoring energy usage."));
        }

        @Test
        void testVoiceCommandProcessor() {
            VoiceCommandProcessor voiceCommandProcessor = new VoiceCommandProcessor();
            stateManager.registerSensor(voiceCommandProcessor);

            stateManager.updateState("voice command: turn on TV");

            assertTrue(outputStream.toString().contains("Processing voice command: voice command: turn on TV"));
        }
    }
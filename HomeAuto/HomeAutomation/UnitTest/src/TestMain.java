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
        void testMotionDetectorTrackMovement()
        {
            MotionDetector motionDetector = new MotionDetector();
            stateManager.registerSensor(motionDetector);

            motionDetector.trackMovement("kitchen", "12:00");

            assertTrue(outputStream.toString().contains("Movement detected at kitchen at 12:00"));
        }

        @Test
        void testLightManager() {
            LightManager lightManager = new LightManager();
            stateManager.registerSensor(lightManager);

            stateManager.updateState("dark environment");

            assertTrue(outputStream.toString().contains("It's dark. Turning on lights."));
        }

    @Test
    void testLightManager2()
    {
        LightManager lightManager = new LightManager();
        stateManager.registerSensor(lightManager);

        stateManager.updateState("bright environment");

        assertTrue(outputStream.toString().contains("It's bright. Turning off lights."));
    }

        @Test
        void testLightManagerAdjustLighting() {
            LightManager lightManager = new LightManager();
            stateManager.registerSensor(lightManager);

            lightManager.adjustLighting(true);

            assertTrue(outputStream.toString().contains("Room is occupied. Turning on lights."));
        }

        @Test
        void testLightManagerAdjustLighting2()
        {
            LightManager lightManager = new LightManager();
            stateManager.registerSensor(lightManager);

            lightManager.adjustLighting(false);

            assertTrue(outputStream.toString().contains("Room is unoccupied. Turning off lights."));
        }


        @Test
        void testLightManagerScene() {
            LightManager lightManager = new LightManager();
            stateManager.registerSensor(lightManager);

            lightManager.setScene("reading");

            assertTrue(outputStream.toString().contains("Setting lighting for reading."));
        }
         @Test
         void testLightManagerScene1()
        {
        LightManager lightManager = new LightManager();
        stateManager.registerSensor(lightManager);

        lightManager.setScene("movie");

        assertTrue(outputStream.toString().contains("Setting lighting for movie watching."));
        }

        @Test
        void testLightManagerScene2()
        {
        LightManager lightManager = new LightManager();
        stateManager.registerSensor(lightManager);

        lightManager.setScene("relaxing");

        assertTrue(outputStream.toString().contains("Setting lighting for relaxing."));
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

        @Test
        void testVoiceCommandProcessorProcessCommand() {
            VoiceCommandProcessor voiceCommandProcessor = new VoiceCommandProcessor();
            stateManager.registerSensor(voiceCommandProcessor);

            voiceCommandProcessor.processCommand("turn on");

            assertTrue(outputStream.toString().contains("Turning on device"));
        }

        @Test
        void testVoiceCommandProcessorTranslateCommand() {
            VoiceCommandProcessor voiceCommandProcessor = new VoiceCommandProcessor();
            stateManager.registerSensor(voiceCommandProcessor);

            voiceCommandProcessor.translateCommand("turn on");

            assertTrue(outputStream.toString().contains("Processing voice command: on"));
        }
    }
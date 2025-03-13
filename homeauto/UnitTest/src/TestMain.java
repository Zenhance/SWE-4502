import models.EnergyConsumptionTracking;
import org.junit.jupiter.api.Test;
import core.StateManager;
import models.MotionDetection;
import models.LightManagement;
import models.TemperatureControl;
import models.EnergyConsumptionTracking;
import models.VoiceCommandProcessor;
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
        MotionDetection motionDetector = new MotionDetection();
        stateManager.registerSensor(motionDetector);

        motionDetector.trackMovement("kitchen", "12:00");

        assertTrue(outputStream.toString().contains("Movement detected at kitchen at 12:00"));
    }

    @Test
    void testLightManager() {
        LightManagement lightManager = new LightManagement();
        stateManager.registerSensor(lightManager);

        stateManager.updateState("dark environment");

        assertTrue(outputStream.toString().contains("It's dark. Turning on lights."));
    }

    @Test
    void testLightManager2()
    {
        LightManagement lightManager = new LightManagement();
        stateManager.registerSensor(lightManager);

        stateManager.updateState("bright environment");

        assertTrue(outputStream.toString().contains("It's bright. Turning off lights."));
    }

    @Test
    void testLightManagerAdjustLighting() {
        LightManagement lightManager = new LightManagement();
        stateManager.registerSensor(lightManager);

        lightManager.adjustLighting(true);

        assertTrue(outputStream.toString().contains("Room is occupied. Turning on lights."));
    }

    @Test
    void testLightManagerAdjustLighting2()
    {
        LightManagement lightManager = new LightManagement();
        stateManager.registerSensor(lightManager);

        lightManager.adjustLighting(false);

        assertTrue(outputStream.toString().contains("Room is unoccupied. Turning off lights."));
    }


    @Test
    void testLightManagerScene() {
        LightManagement lightManager = new LightManagement();
        stateManager.registerSensor(lightManager);

        lightManager.setScene("reading");

        assertTrue(outputStream.toString().contains("Setting lighting for reading."));
    }
    @Test
    void testLightManagerScene1()
    {
        LightManagement lightManager = new LightManagement();
        stateManager.registerSensor(lightManager);

        lightManager.setScene("movie");

        assertTrue(outputStream.toString().contains("Setting lighting for movie watching."));
    }

    @Test
    void testLightManagerScene2()
    {
        LightManagement lightManager = new LightManagement();
        stateManager.registerSensor(lightManager);

        lightManager.setScene("relaxing");

        assertTrue(outputStream.toString().contains("Setting lighting for relaxing."));
    }


    @Test
    void testTemperatureControllerCold() {
        TemperatureControl temperatureController = new TemperatureControl();
        stateManager.registerSensor(temperatureController);

        stateManager.updateState("cold temperature");

        assertTrue(outputStream.toString().contains("It's cold. Turning on heating."));
    }


    @Test
    void testTemperatureControllerHot() {
        TemperatureControl temperatureController = new TemperatureControl();
        stateManager.registerSensor(temperatureController);

        stateManager.updateState("hot temperature");

        assertTrue(outputStream.toString().contains("It's hot. Turning on cooling."));
    }

    @Test
    void testEnergyTracker() {
        EnergyConsumptionTracking energyTracker = new EnergyConsumptionTracking();
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
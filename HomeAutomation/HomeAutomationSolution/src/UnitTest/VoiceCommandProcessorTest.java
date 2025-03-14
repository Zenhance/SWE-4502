package UnitTest;



import LightManagement.LightController;
import TemperatureControl.TemperatureController;
import VoiceCommandSystem.LightOnCommand;
import VoiceCommandSystem.TemperatureSetCommand;
import VoiceCommandSystem.VoiceCommandProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VoiceCommandProcessorTest {
    private VoiceCommandProcessor processor;
    private LightController lightController;
    private TemperatureController temperatureController;

    @BeforeEach
    void setUp() {
        processor = new VoiceCommandProcessor();
        lightController = new LightController();
        temperatureController = new TemperatureController(22);

        processor.registerCommand("turn on light", new LightOnCommand(lightController));
        processor.registerCommand("set temperature", new TemperatureSetCommand(temperatureController, 24));
    }

    @Test
    void testValidLightCommand() {
        processor.processCommand("turn on light");
        assertEquals("Reading", lightController.getCurrentScene(), "Light should be set to Reading mode.");
    }

    @Test
    void testUnknownCommand() {
        processor.processCommand("open door");
        // No assertion needed; just ensuring no crash occurs
    }
}

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VoiceCommandSystemTest {

    private VoiceCommandSystem voiceCommandSystem;

    @BeforeEach
    void setUp() {
        voiceCommandSystem = new VoiceCommandSystem();
    }

    @Test
    void testTurnOnLightsCommand() {
        // Test the "Turn on the lights" command
        voiceCommandSystem.processCommand("Turn on the lights");

        assertTrue(voiceCommandSystem.areLightsOn(), "Lights should be ON after the command.");
    }

    @Test
    void testTurnOffLightsCommand() {
        // Test the "Turn off the lights" command
        voiceCommandSystem.processCommand("Turn off the lights");

        assertFalse(voiceCommandSystem.areLightsOn(), "Lights should be OFF after the command.");
    }

    @Test
    void testSetTemperatureCommand() {
        // Test the "Set temperature to 24" command
        voiceCommandSystem.processCommand("Set temperature to 24");

        assertEquals(24.0, voiceCommandSystem.getTargetTemperature(), "Target temperature should be 24°C.");
    }

    @Test
    void testUnrecognizedCommand() {
        // Test an unrecognized command
        voiceCommandSystem.processCommand("Turn on the air conditioning");

        // Since the command is unrecognized, we expect no change in the system state
        assertEquals(22.0, voiceCommandSystem.getTargetTemperature(), "Target temperature should remain 22°C.");
        assertFalse(voiceCommandSystem.areLightsOn(), "Lights should remain OFF.");
    }

    @Test
    void testCommandHistory() {
        // Process a few commands
        voiceCommandSystem.processCommand("Turn on the lights");
        voiceCommandSystem.processCommand("Set temperature to 25");
        voiceCommandSystem.processCommand("Turn off the lights");

        // Check the command history
        assertEquals(3, voiceCommandSystem.getCommandHistory().size(), "There should be 3 commands in history.");
        assertEquals("Turn on the lights", voiceCommandSystem.getCommandHistory().get(0), "First command in history should be 'Turn on the lights'.");
        assertEquals("Set temperature to 25", voiceCommandSystem.getCommandHistory().get(1), "Second command in history should be 'Set temperature to 25'.");
        assertEquals("Turn off the lights", voiceCommandSystem.getCommandHistory().get(2), "Third command in history should be 'Turn off the lights'.");
    }
}
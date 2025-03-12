

import Components.VoiceCommandProcessor;
import Core.EnvironmentState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VoiceCommandProcessorTest {
    private EnvironmentState envState;
    private VoiceCommandProcessor voiceCommandProcessor;

    @BeforeEach
    void setUp() {
        envState = new EnvironmentState();
        voiceCommandProcessor = new VoiceCommandProcessor(envState);
    }

    @Test
    void testVoiceCommandTurnsOnLights() {
        voiceCommandProcessor.processCommand("TURN ON LIGHTS");
        assertEquals(0, envState.getState("LIGHT_LEVEL")); // Ensures lights turned on
    }

    @Test
    void testVoiceCommandTurnsOffLights() {
        voiceCommandProcessor.processCommand("TURN OFF LIGHTS");
        assertEquals(100, envState.getState("LIGHT_LEVEL")); // Ensures lights turned off
    }

    @Test
    void testVoiceCommandSetsTemperature() {
        voiceCommandProcessor.processCommand("SET TEMPERATURE TO 24");
        assertEquals(24.0, envState.getState("TEMPERATURE")); // Ensures temperature is set
    }

    @Test
    void testVoiceCommandIgnoresInvalidCommands() {
        voiceCommandProcessor.processCommand("INVALID COMMAND");
        assertNull(envState.getState("INVALID COMMAND")); // Ensures no invalid change
    }

    @Test
    void testVoiceCommandHistory() {
        voiceCommandProcessor.processCommand("TURN ON LIGHTS");
        voiceCommandProcessor.processCommand("SET TEMPERATURE TO 24");
        assertEquals(2, voiceCommandProcessor.getCommandHistory().size()); // Ensures history tracks commands
    }
}

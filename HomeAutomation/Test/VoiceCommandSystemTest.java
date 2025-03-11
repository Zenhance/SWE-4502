package Test;

import org.junit.jupiter.api.Test;
import Code.Controllers.VoiceCommandSystem;
import Code.StateManagementClasses.StateManager;
import static org.junit.jupiter.api.Assertions.*;

class VoiceCommandSystemTest {

    // Test if a valid command is processed and stored in history
    @Test
    void testOnStateChange_VoiceCommandReceived() {
        StateManager stateManager = new StateManager();
        VoiceCommandSystem voiceCommandSystem = new VoiceCommandSystem(stateManager);

        voiceCommandSystem.onStateChange("voiceCommand", "Turn on the lights");

        assertEquals(1, voiceCommandSystem.getCommandHistory().size(), "Command history should contain 1 entry.");
        assertEquals("Turn on the lights", voiceCommandSystem.getCommandHistory().get(0), "First command should be 'Turn on the lights'.");
    }

    // Test if an unknown command is still stored in history but doesn't change the system state
    @Test
    void testOnStateChange_InvalidCommand() {
        StateManager stateManager = new StateManager();
        VoiceCommandSystem voiceCommandSystem = new VoiceCommandSystem(stateManager);

        voiceCommandSystem.onStateChange("voiceCommand", "Play music");

        assertEquals(1, voiceCommandSystem.getCommandHistory().size(), "Unknown command should still be added to history.");
        assertEquals("Play music", voiceCommandSystem.getCommandHistory().get(0), "Command history should store 'Play music'.");
    }

    // Test if an invalid key does nothing
    @Test
    void testOnStateChange_InvalidKey() {
        StateManager stateManager = new StateManager();
        VoiceCommandSystem voiceCommandSystem = new VoiceCommandSystem(stateManager);

        voiceCommandSystem.onStateChange("invalidKey", "Turn on the lights");

        assertTrue(voiceCommandSystem.getCommandHistory().isEmpty(), "No command should be processed for an invalid key.");
    }
}

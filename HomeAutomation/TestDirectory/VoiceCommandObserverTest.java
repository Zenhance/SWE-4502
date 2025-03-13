import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VoiceCommandObserverTest {

    // Test 1: Voice Command Processing
    @Test
    void testVoiceCommandProcessing() {
        VoiceCommandSystem voiceSystem = new VoiceCommandSystem();
        VoiceCommandObserver observer = new VoiceCommandObserver();

        // Register observer
        voiceSystem.registerObserver(observer);

        // Simulate voice commands
        voiceSystem.receiveVoiceCommand("turn on the lights");
        voiceSystem.receiveVoiceCommand("deactivate the alarm");

        // Assert that the observer correctly processed the commands
        assertTrue(observer.getCommandHistory().contains("turn on the lights"));
        assertTrue(observer.getCommandHistory().contains("deactivate the alarm"));
    }

    // Test 2: Unknown Voice Command
    @Test
    void testUnknownVoiceCommand() {
        VoiceCommandSystem voiceSystem = new VoiceCommandSystem();
        VoiceCommandObserver observer = new VoiceCommandObserver();

        // Register observer
        voiceSystem.registerObserver(observer);

        // Simulate an unknown command
        voiceSystem.receiveVoiceCommand("play music");

        // Assert that the unknown command is logged
        assertTrue(observer.getCommandHistory().contains("play music"));
    }

    // Test 3: Command History Size
    @Test
    void testCommandHistorySize() {
        VoiceCommandSystem voiceSystem = new VoiceCommandSystem();
        VoiceCommandObserver observer = new VoiceCommandObserver();

        // Register observer
        voiceSystem.registerObserver(observer);

        // Simulate multiple voice commands
        voiceSystem.receiveVoiceCommand("turn on the lights");
        voiceSystem.receiveVoiceCommand("deactivate the alarm");
        voiceSystem.receiveVoiceCommand("increase the temperature");

        // Assert that the command history size matches the number of commands processed
        assertEquals(3, observer.getCommandHistory().size());
    }

}

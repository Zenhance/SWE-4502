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

}

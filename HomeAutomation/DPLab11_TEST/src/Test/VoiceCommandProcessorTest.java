package Test;

import components.VoiceCommandProcessor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VoiceCommandProcessorTest {

    @Test
    void testProcessCommandTurnOn() {
        VoiceCommandProcessor voiceCommandProcessor = new VoiceCommandProcessor();
        voiceCommandProcessor.processCommand("turn on the light");
        assertTrue(voiceCommandProcessor.getCommandHistory().contains("turn on the light"));
    }

   
}

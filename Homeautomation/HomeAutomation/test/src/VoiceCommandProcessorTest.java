import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class VoiceCommandProcessorTest {

    @Test
    void testVoiceCommandProcessing() {
        VoiceCommandProcessor processor = new VoiceCommandProcessor();

        // Test command execution
        processor.processCommand("Turn on lights");
        processor.processCommand("Set temperature to 24");

        List<String> history = processor.getCommandHistory();
        assertEquals(2, history.size(), "There should be 2 commands in history");
        assertEquals("Turn on lights", history.get(0), "First command should be 'Turn on lights'");
        assertEquals("Set temperature to 24", history.get(1), "Second command should be 'Set temperature to 24'");
    }
}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VoiceCommandTest {
    public SystemState state;
    public VoiceCommandFollower command;

    @BeforeEach
    public void setup() {
        state = new SystemState();
        command = new VoiceCommandFollower();
    }

    @Test
    public void testTurnOnLights() {
        state.voiceCommand = "Turn on the lights";
        command.update(state);
        assertTrue(state.setLightsOn);
    }

    @Test
    public void testTurnOffLights() {
        state.voiceCommand = "Turn off the lights";
        command.update(state);
        assertFalse(state.setLightsOn);
    }


    @Test
    public void testCommandHistory() {
        state.voiceCommand = "Turn on the lights";
        command.update(state);
        state.voiceCommand = "Turn off the lights";
        command.update(state);

        assertEquals(2, command.commandHistory.size());
    }

    @Test
    public void testUnrecognizedCommand() {
        state.voiceCommand = "Open the windows";
        command.update(state);
        assertFalse(state.setLightsOn);

    }
}

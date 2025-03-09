import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VoiceCommandTest {
    public SystemState state;
    public VoiceCommandFollower command;
    public SystemStateManager sysState;

    @BeforeEach
    public void setup() {
        state = new SystemState();
        command = new VoiceCommandFollower();
        sysState = new SystemStateManager();
        sysState.registerObserver(command);
    }

    @Test
    public void testTurnOnLights() {
        state.voiceCommand = "Turn on the lights";
        command.update(state);
        assertTrue(state.setLightsOn);
        sysState.setState(state);
    }

    @Test
    public void testTurnOffLights() {
        state.voiceCommand = "Turn off the lights";
        command.update(state);
        assertFalse(state.setLightsOn);
        sysState.setState(state);
    }


    @Test
    public void testCommandHistory() {
        state.voiceCommand = "Turn on the lights";
        sysState.setState(state);
        state.voiceCommand = "Turn off the lights";
        sysState.setState(state);

        assertEquals(2, command.commandHistory.size());

    }

    @Test
    public void testUnrecognizedCommand() {
        state.voiceCommand = "Open the windows";
        sysState.setState(state);
        assertFalse(state.setLightsOn);

    }
}

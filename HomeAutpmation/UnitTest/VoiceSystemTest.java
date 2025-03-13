import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VoiceSystemTest {

    private VoiceSystem voiceCommandFollower;
    private SystemState systemState;

    @BeforeEach
    public void setUp() {
        voiceCommandFollower = new VoiceSystem();
        systemState = new SystemState();
    }
    @Test
    public void testTurnOnLightsCommand() {
        systemState.setStateDescription("Turn On Lights");
        voiceCommandFollower.update(systemState);
        assertEquals("Processing command: Turn On Lights", voiceCommandFollower.getLastAction());
        assertTrue(voiceCommandFollower.getCommandHistory().contains("Turn On Lights"));
    }

    @Test
    public void testTurnOffLightsCommand() {
        systemState.setStateDescription("Turn Off Lights");
        voiceCommandFollower.update(systemState);
        assertEquals("Processing command: Turn Off Lights", voiceCommandFollower.getLastAction());
        assertTrue(voiceCommandFollower.getCommandHistory().contains("Turn Off Lights"));
    }



    @Test
    public void testMultipleCommands() {
        systemState.setStateDescription("Turn On Lights");
        voiceCommandFollower.update(systemState);

        systemState.setStateDescription("Turn Off Lights");
        voiceCommandFollower.update(systemState);

        systemState.setStateDescription("Dim Lights");
        voiceCommandFollower.update(systemState);


        assertTrue(voiceCommandFollower.getCommandHistory().contains("Turn On Lights"));
        assertTrue(voiceCommandFollower.getCommandHistory().contains("Turn Off Lights"));
        assertFalse(voiceCommandFollower.getCommandHistory().contains("Dim Lights"));
    }


}

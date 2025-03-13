import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VoiceCommandSystemTest {
    private HomeState homeState;
    private VoiceCommandSystem voiceSystem;

    @BeforeEach
    void setUp() {
        homeState = new HomeState();
        voiceSystem = new VoiceCommandSystem(homeState, "living-room");
    }

    @Test
    void testTurnOnLightsCommand() {
        voiceSystem.sendCommand("turn on lights");
        Object status = homeState.getState("lights-living-room");
        assertTrue(status != null && (Boolean) status);
    }


    @Test
    void testTurnOffLightsCommand() {
        voiceSystem.sendCommand("turn off lights");
        Object status = homeState.getState("lights-living-room");
        assertFalse(status != null && (Boolean) status);
    }

    @Test
    void testCommandHistory() {
        voiceSystem.sendCommand("turn on lights");
        voiceSystem.sendCommand("turn off lights");
        assertEquals(2, voiceSystem.getCommandHistory().size());
        assertEquals("turn on lights", voiceSystem.getCommandHistory().get(0));
        assertEquals("turn off lights", voiceSystem.getCommandHistory().get(1));
    }


}
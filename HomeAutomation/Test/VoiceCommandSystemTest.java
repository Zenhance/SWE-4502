// src/test/java/VoiceCommandSystemTest.java
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


}
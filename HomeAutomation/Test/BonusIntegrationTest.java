import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BonusIntegrationTest {
    private HomeState homeState;
    private VoiceCommandSystem voiceSystem;
    private LightManager lightManager;

    @BeforeEach
    void setUp() {
        homeState = new HomeState();
        voiceSystem = new VoiceCommandSystem(homeState, "room");
        lightManager = new LightManager(homeState, "room");
    }

    @Test
    void testLightsViaVoiceCommand() {
        voiceSystem.sendCommand("turn on lights");
        assertTrue(lightManager.isLightsOn());
    }
}
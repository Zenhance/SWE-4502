import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VoiceCommandTest {
    @Test
    void testVoice(){
        VoiceCommandSystem voiceCommandSystem=new VoiceCommandSystem();
        EnvironmentState state=new EnvironmentState();

        state.updateState("voiceCommand","YayYayyayy");

        voiceCommandSystem.update(state);

        assertTrue(voiceCommandSystem.isVoiceDetected());
    }
}

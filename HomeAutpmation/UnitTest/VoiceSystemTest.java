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


   
}

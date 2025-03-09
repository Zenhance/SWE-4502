import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EdgeCaseTest {
    private SystemStateManager sysState;
    private RemoteAccessApp remoteAccessApp;

    @BeforeEach
    public void setup() {
        sysState = new SystemStateManager();
        remoteAccessApp = new RemoteAccessApp(sysState);
    }


    @Test
    public void testUnrecognizedCommand() {
        String result = remoteAccessApp.remoteControl("open the windows");
        assertEquals("ERROR: Unrecognized command!", result);
    }

    @Test
    public void testSystemWithNoObservers() {
        sysState = new SystemStateManager();
        SystemState state = new SystemState();
        state.motionDetected = true;
        sysState.setState(state);
        assertNotNull(sysState.state);
    }
}

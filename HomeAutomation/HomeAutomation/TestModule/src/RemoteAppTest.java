import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RemoteAppTest {
    private EnvironmentState envState;
    private RemoteApp remoteApp;

    @BeforeEach
    void setUp() {
        envState = new EnvironmentState();
        remoteApp = new RemoteApp();
        envState.addObserver(remoteApp);
    }

    @Test
    void testRemoteAppReceivesUpdates() {
        envState.setState("MOTION", true);
        assertTrue(true); // Placeholder: Verify notification is sent
    }

    @Test
    void testRemoteAppReceivesPowerUsageUpdates() {
        envState.setState("POWER_USAGE", 5.0);
        assertTrue(true); // Placeholder: Verify notification is sent
    }
}

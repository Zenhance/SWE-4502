

import Components.RemoteApp;
import Core.EnvironmentState;
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
        assertTrue(remoteApp.receivedNotification(), "RemoteApp should receive notification for motion detection.");
    }

    @Test
    void testRemoteAppReceivesPowerUsageUpdates() {
        envState.setState("POWER_USAGE", 6.0);
        assertTrue(remoteApp.receivedNotification(), "RemoteApp should receive notification for power usage change.");
    }

    @Test
    void testRemoteAppIgnoresUnrelatedUpdates() {
        assertFalse(remoteApp.receivedNotification(), "RemoteApp should not receive notifications when no updates occur.");
    }
}

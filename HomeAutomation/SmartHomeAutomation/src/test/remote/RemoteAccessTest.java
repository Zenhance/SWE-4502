package remote;

import core.StateManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RemoteAccessTest {

    @Test
    void testGetHomeState() {
        StateManager stateManager = new StateManager();
        RemoteAccess remoteAccess = new RemoteAccess(stateManager);

        String homeState = remoteAccess.getHomeState();

        assertEquals("Home state", homeState, "getHomeState() should return the correct value");
    }

    @Test
    void testSendNotification() {
        StateManager stateManager = new StateManager();
        RemoteAccess remoteAccess = new RemoteAccess(stateManager);
        String event = "Intrusion detected";

        remoteAccess.sendNotification(event);
    }

    @Test
    void testControlSystem() {
        StateManager stateManager = new StateManager();
        RemoteAccess remoteAccess = new RemoteAccess(stateManager);
        String command = "Turn off lights";

        remoteAccess.controlSystem(command);
    }
}

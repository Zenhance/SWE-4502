package Test;

import org.junit.jupiter.api.Test;
import Code.StateManagementClasses.StateManager;
import Code.Controllers.RemoteAccessApp;
import static org.junit.jupiter.api.Assertions.*;

class RemoteAccessAppTest {

    // Test if state updates correctly
    @Test
    void testOnStateChange_StateUpdated() {
        StateManager stateManager = new StateManager();
        RemoteAccessApp remoteAccessApp = new RemoteAccessApp(stateManager);

        remoteAccessApp.onStateChange("temperature", 22.5);

        assertEquals(22.5, remoteAccessApp.getState("temperature"), "Temperature should be updated to 22.5.");
    }

    // Test if multiple state updates are handled
    @Test
    void testOnStateChange_MultipleUpdates() {
        StateManager stateManager = new StateManager();
        RemoteAccessApp remoteAccessApp = new RemoteAccessApp(stateManager);

        remoteAccessApp.onStateChange("temperature", 22.5);
        remoteAccessApp.onStateChange("lightLevel", 50.0);

        assertEquals(22.5, remoteAccessApp.getState("temperature"), "Temperature should be updated.");
        assertEquals(50.0, remoteAccessApp.getState("lightLevel"), "Light level should be updated.");
    }

}

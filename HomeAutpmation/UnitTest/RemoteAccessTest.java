import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RemoteAccessTest {

    private RemoteAccess remoteAccessApp;
    private SystemState systemState;

    @BeforeEach
    public void setUp() {
        remoteAccessApp = new RemoteAccess();
        systemState = new SystemState();
    }

    @Test
    public void testGenerateNotificationForSystemAlert() {
        systemState.setStateDescription("System Alert");
        remoteAccessApp.update(systemState);
        assertEquals("Notification: Important event occurred in the system.", remoteAccessApp.getLastAction());
    }

    @Test
    public void testDisplayCurrentState() {
        systemState.setStateDescription("Room Occupied");
        remoteAccessApp.update(systemState);
        assertEquals("Current home state: Room Occupied", remoteAccessApp.getLastAction());
    }

    @Test
    public void testMultipleUpdates() {
        systemState.setStateDescription("System Alert");
        remoteAccessApp.update(systemState);
        assertEquals("Notification: Important event occurred in the system.", remoteAccessApp.getLastAction());


        systemState.setStateDescription("Room Unoccupied");
        remoteAccessApp.update(systemState);
        assertEquals("Current home state: Room Unoccupied", remoteAccessApp.getLastAction());
    }



}

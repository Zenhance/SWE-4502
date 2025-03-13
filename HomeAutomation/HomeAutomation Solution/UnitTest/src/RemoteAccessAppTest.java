import RemoteAccessApp.*;
import Commands.Command;
import CoreFramework.HomeEnvironment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class RemoteAccessAppTest {
    private RemoteAccessApp remoteAccessApp;
    private HomeEnvironment homeEnvironment;

    @BeforeEach
    void setUp() {
        homeEnvironment = HomeEnvironment.getInstance();
        remoteAccessApp = new RemoteAccessApp();
    }

    @Test
    void testObserverUpdatesCurrentState() {
        homeEnvironment.setState("temperature", 22.5);
        assertEquals(22.5, remoteAccessApp.getCurrentState().get("temperature"),
                "Temperature should be updated in current state");

        homeEnvironment.setState("roomOccupancy", true);
        assertEquals(true, remoteAccessApp.getCurrentState().get("roomOccupancy"),
                "Room occupancy should be updated in current state");
    }

    @Test
    void testMotionDetectionTriggersNotification() {
        homeEnvironment.setState("motion", true);

        List<String> notifications = remoteAccessApp.getNotifications();
        assertFalse(notifications.isEmpty(), "Notifications should not be empty after motion detection");
        assertEquals("Motion detected at home", notifications.get(0),
                "Motion notification should be correctly logged");
    }

    @Test
    void testHighPowerUsageTriggersNotification() {
        homeEnvironment.setState("powerUsage", 6000.0);

        List<String> notifications = remoteAccessApp.getNotifications();
        assertFalse(notifications.isEmpty(), "Notifications should not be empty after high power usage detection");
        assertEquals("High power usage detected: 6000.0 watts", notifications.get(0),
                "High power usage notification should be correctly logged");
    }

}


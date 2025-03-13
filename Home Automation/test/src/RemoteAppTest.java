import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RemoteAppTest {

    private RemoteApp remoteApp;
    private EnvironmentState environmentState;

    @BeforeEach
    void setUp() {
        // Initialize RemoteApp and EnvironmentState
        remoteApp = new RemoteApp();
        environmentState = new EnvironmentState();

        // Register RemoteApp as an observer of the EnvironmentState
        environmentState.addObserver(remoteApp);
    }

    @Test
    void testTemperatureUpdateAndNotification() {
        // Simulate a temperature update
        double temperature = 26.0;
        environmentState.setState("TEMPERATURE", temperature);

        // Assert that the RemoteApp received a notification
        assertTrue(remoteApp.isNotificationReceived(), "Notification should be received when temperature exceeds threshold.");
    }

    @Test
    void testMotionDetection() {
        // Simulate motion detection
        boolean motionDetected = true;
        environmentState.setState("MOTION", motionDetected);

        // Assert that the RemoteApp received a motion detection notification
        assertTrue(remoteApp.isNotificationReceived(), "Notification should be received when motion is detected.");
    }

    @Test
    void testNoMotion() {
        // Simulate no motion
        boolean motionDetected = false;
        environmentState.setState("MOTION", motionDetected);

        // Assert no notification for motion detection
        assertFalse(remoteApp.isNotificationReceived(), "Notification should not be received when no motion is detected.");
    }

    @Test
    void testStateChange() {
        // Test changing state of the RemoteApp
        remoteApp.setState("Active");
        assertEquals("Active", remoteApp.getCurrentState(), "RemoteApp state should be 'Active' after change.");
    }
}
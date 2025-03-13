import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RemoteAccessAppTest {
    private HomeState homeState;
    private RemoteAccessApp remoteApp;

    @BeforeEach
    void setUp() {
        homeState = new HomeState();
        remoteApp = new RemoteAccessApp(homeState, "kitchen");
    }

    @Test
    void testGetLightsState() {
        homeState.setState("lights-kitchen", true);
        assertTrue(remoteApp.getLightsState());
    }

    @Test
    void testGetTemperature() {
        homeState.setState("temp-kitchen", 22);
        assertEquals(22, remoteApp.getTemperature());
    }

    @Test
    void testSuspiciousMotionNotification() {
        homeState.setState("suspicious-kitchen", true);
        assertEquals(1, remoteApp.getNotifications().size());
        assertEquals("Suspicious motion detected in kitchen", remoteApp.getNotifications().get(0));
    }

    @Test
    void testHighEnergyUsageNotification() {
        homeState.setState("unusual-usage", true);
        assertEquals(1, remoteApp.getNotifications().size());
        assertEquals("High energy usage detected", remoteApp.getNotifications().get(0));
    }


}
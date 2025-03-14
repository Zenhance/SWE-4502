

import CoreFramework.EnvironmentMonitor;
import CoreFramework.EnvironmentState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import RemoteAccessApp.*;
public class RemoteAccessAppTest {
    private RemoteAccessApp remoteApp;
    private NotificationService notificationService;
    private EnvironmentMonitor monitor;

    @BeforeEach
    void setUp() {
        notificationService = new NotificationService();
        remoteApp = new RemoteAccessApp(notificationService);
        monitor = new EnvironmentMonitor();
        monitor.registerObserver(remoteApp);
    }

    @Test
    void testNotificationForHighPowerUsage() {
        monitor.setState(new EnvironmentState(false, 22, 60 )); // 6000W usage
        List<String> notifications = remoteApp.getNotifications();
        assertTrue(notifications.contains(" High Power Usage: 6000W"), "High power usage alert should be sent.");
    }

    @Test
    void testNotificationForHighTemperature() {
        monitor.setState(new EnvironmentState(false, 32, 30)); // 32°C
        List<String> notifications = remoteApp.getNotifications();
        assertTrue(notifications.contains(" Warning: High Temperature Detected (32°C)"), "High temperature alert should be sent.");
    }
}

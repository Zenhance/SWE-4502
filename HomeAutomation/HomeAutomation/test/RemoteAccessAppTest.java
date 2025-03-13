import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class RemoteAccessAppTest {
    private EnvironmentMonitor monitor;
    private RemoteAccessApp remoteApp;

    @Before
    public void setUp() {
        monitor = new EnvironmentMonitor();
        remoteApp = new RemoteAccessApp(monitor);
        monitor.registerObserver(remoteApp); // Explicit registration for clarity and control
    }

    // ✅ Test 1: Display current state of the home environment
    @Test
    public void testDisplayCurrentState() {
        EnvironmentState state = new EnvironmentState(22.0, true, 30.0);
        monitor.setState(state);

        // Verify notification generation or check the console output
        assertEquals("Alert: Motion detected!", remoteApp.getNotifications().get(0));
    }

    // ✅ Test 2: Generate notifications for important events
    @Test
    public void testGenerateNotifications() {
        monitor.setState(new EnvironmentState(10.0, false, 30.0));
        assertTrue(remoteApp.getNotifications().contains("Warning: Unusual temperature detected - 10.0°C"));
    }

    // ✅ Test 3: Remote control - Turn off lights
    @Test
    public void testRemoteControlTurnOffLights() {
        remoteApp.controlLights(false, 0);
        assertEquals(0, monitor.state.lightLevel, 0.01);
    }

    // ✅ Test 4: Remote control - Set temperature
    @Test
    public void testRemoteControlSetTemperature() {
        remoteApp.setTemperature(24.0);
        assertEquals(24.0, monitor.state.temperature, 0.01);
    }
}

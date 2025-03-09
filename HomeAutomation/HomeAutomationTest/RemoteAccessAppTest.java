import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RemoteAccessAppTest {
    public SystemStateManager sysStateManager;
    public RemoteAccessApp remoteAccessApp;
    public SystemState state;

    @BeforeEach
    public void setup() {
        sysStateManager = new SystemStateManager();
        remoteAccessApp = new RemoteAccessApp(sysStateManager);
        state = new SystemState();

    }

    @Test
    public void testDisplayCurrentState() {
        state.motionDetected = true;
        state.roomOccupied = true;
        state.lightLevel = 50;
        state.setLightsOn = true;
        state.temperature = 22;
        state.energyUsage = 500.0;

        sysStateManager.setState(state);

        String expectedOutput = """
                Home System Status:
                Motion Detected: Yes
                Room Occupied: Yes
                Light Level: 50
                Lights On: Yes
                Temperature: 22°C
                Energy Usage: 500.0 watts""";

        assertEquals(expectedOutput, remoteAccessApp.displayCurrentState());


    }

    @Test
    public void testGenerateNotification() {
        String notificationMessage = remoteAccessApp.generateNotification("Lights turned on remotely");
        assertEquals("NOTIFICATION: Lights turned on remotely", notificationMessage);
    }
}

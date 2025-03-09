package ComponentsTest;

import static org.junit.jupiter.api.Assertions.*;

import Components.RemoteAccessApp;
import Core_Models.SystemState;
import Core_Models.SystemStateManager;
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


    @Test
    public void testRemoteControlForLightOn(){
        String result = remoteAccessApp.remoteControl("turn on the lights");
        assertEquals("NOTIFICATION: Lights turned ON remotely.", result);
        assertTrue(sysStateManager.state.setLightsOn);
    }

    @Test
    public void testRemoteControlForLightOff(){
        String result = remoteAccessApp.remoteControl("turn off the lights");
        assertEquals("NOTIFICATION: Lights turned OFF remotely.", result);
        assertFalse(sysStateManager.state.setLightsOn);
    }
}

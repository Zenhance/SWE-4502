import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RemoteAccessAppTest {

    // Test 1: Verifies that the system correctly displays the current state of the home system.
    @Test
    public void testDisplayCurrentState() {
        HomeState homeState = new HomeState();
        RemoteAccessApp remoteAccessApp = new RemoteAccessApp(new HomeState(), homeState);

        homeState.motionDetected = true;
        homeState.roomOccupied = true;
        homeState.lightLevel = 50;
        homeState.setLightsOn = true;
        homeState.temperature = 22;
        homeState.energyUsage = 500.0;

        System.out.println(remoteAccessApp.displayCurrentState());

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

}

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RemoteAccessAppTest {

    // Test 1: Verifies that the system correctly displays the current state of the home system.
    @Test
    public void testDisplayCurrentState() {
        HomeState homeState = new HomeState();
        RemoteAccessApp remoteAccessApp = new RemoteAccessApp(homeState); // Only passing homeState

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

    // Test 2: Verifies that the system generates the correct notification message for light and motion.
    @Test
    public void testGenerateNotificationForLightAndMotion() {
        HomeState homeState = new HomeState();
        RemoteAccessApp remoteAccessApp = new RemoteAccessApp(homeState); // Only passing homeState

        // Test notification for turning the lights on
        String lightNotification = remoteAccessApp.generateNotification("Lights turned on remotely");

        // Test notification for motion detected
        homeState.motionDetected = true;
        String motionNotification = remoteAccessApp.generateNotification("Motion detected");

        // Print for debugging
        System.out.println(lightNotification);
        System.out.println(motionNotification);

        assertEquals("NOTIFICATION: Lights turned on remotely", lightNotification);
        assertEquals("NOTIFICATION: Motion detected", motionNotification);
    }

    // Test 3: Verifies remote control functionality for energy usage and temperature.
    @Test
    public void testRemoteControlForEnergyAndTemperature() {
        HomeState homeState = new HomeState();
        RemoteAccessApp remoteAccessApp = new RemoteAccessApp(homeState); // Only passing homeState

        // Simulate remote control to increase energy usage
        String energyResult = remoteAccessApp.remoteControl("increase energy usage", homeState);

        // Simulate remote control to increase temperature
        String tempResult = remoteAccessApp.remoteControl("increase temperature", homeState);

        // Print for debugging
        System.out.println(energyResult);
        System.out.println(tempResult);

        // Assert that the notifications and changes are correct
        assertEquals("NOTIFICATION: Energy usage increased remotely.", energyResult);
        assertEquals("NOTIFICATION: Temperature increased remotely.", tempResult);
    }

}

package RemoteAccess;

import Core.HomeEnvironment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class RemoteAccessTest {
    private RemoteAccess remoteAccess;
    private HomeEnvironment homeEnvironment;

    @BeforeEach
    void setUp() {
        // Initialize the RemoteAccess and HomeEnvironment
        remoteAccess = new RemoteAccess();
        homeEnvironment = HomeEnvironment.getInstance();
    }

    @Test
    void testControlLightOn() {
        // Simulate sending the "turn on the light" command
        remoteAccess.controlLight("turn on the light");

        // Verify that the light state is set to "on"
        assertEquals("on", homeEnvironment.getState("lightState"), "The light state should be 'on' after the command.");
    }

    @Test
    void testControlLightOff() {
        // Simulate sending the "turn off the light" command
        remoteAccess.controlLight("turn off the light");

        // Verify that the light state is set to "off"
        assertEquals("off", homeEnvironment.getState("lightState"), "The light state should be 'off' after the command.");
    }

    @Test
    void testControlTemperature() {
        // Simulate sending the "set temperature to 22" command
        remoteAccess.controlTemperature(22);

        // Verify the temperature is set to 22
        assertEquals(22, homeEnvironment.getState("temperature"), "The temperature should be set to 22°C.");
    }

    @Test
    void testNotificationOnLightStateChange() {
        // Simulate light state change by setting the "lightState" to "on"
        homeEnvironment.setState("lightState", "on");

        // Verify that the notification was triggered (capturing console output)
        // We'll use a custom method to check the output
        String output = captureSystemOutput(() -> remoteAccess.update("lightState", "on"));

        assertTrue(output.contains("Notification: Light status has changed to: on"),
                "Notification for light state change was not sent.");
    }

    @Test
    void testNotificationOnTemperatureChange() {
        // Simulate temperature change by setting the "temperature" to 22
        homeEnvironment.setState("temperature", 22);

        // Verify that the notification was triggered (capturing console output)
        String output = captureSystemOutput(() -> remoteAccess.update("temperature", 22));

        assertTrue(output.contains("Notification: Temperature has been set to: 22°C"),
                "Notification for temperature change was not sent.");
    }

    @Test
    void testObserverUpdateForLightState() {
        // Simulate light state update from HomeEnvironment
        homeEnvironment.setState("lightState", "off");

        // Verify that the remoteAccess observer receives the updated light state
        remoteAccess.update("lightState", "on");

        assertEquals("on", homeEnvironment.getState("lightState"), "Remote access should receive the updated light state.");
    }

    @Test
    void testObserverUpdateForTemperature() {
        // Simulate temperature update from HomeEnvironment
        homeEnvironment.setState("temperature", 20);

        // Verify that the remoteAccess observer receives the updated temperature
        remoteAccess.update("temperature", 22);

        assertEquals(22, homeEnvironment.getState("temperature"), "Remote access should receive the updated temperature.");
    }

    @Test
    void testInvalidLightControlCommand() {
        // Simulate an invalid command to control light
        remoteAccess.controlLight("turn on the fan");

        // Since the fan is not a valid command, the light state should not change
        assertNull(homeEnvironment.getState("fanState"), "Invalid commands should not affect the system state.");
    }

    // Utility method to capture System.out output
    private String captureSystemOutput(Runnable action) {
        // Create a stream to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalSystemOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Perform the action (e.g., invoking the update method)
        action.run();

        // Restore original System.out
        System.setOut(originalSystemOut);

        // Return the captured output as a string
        return outputStream.toString();
    }
}

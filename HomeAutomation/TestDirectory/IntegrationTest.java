import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTest {

    @Test
    void testEnergyControlWithVoiceCommand() {
        // Create the home state object as Subject
        HomeState homeState = new HomeState();

        // Now, create the RemoteAccessApp and pass homeState (which extends Subject)
        RemoteAccessApp remoteAccessApp = new RemoteAccessApp(homeState);

        // Set up the system state
        homeState.energyUsage = 200;

        // Simulate a voice command (e.g., increase energy usage)
        String result = remoteAccessApp.remoteControl("increase energy usage", homeState);

        // Print the result of the remote control command for debugging
        System.out.println("Result of Remote Control: " + result);

        // Verify the energy usage has increased and the app is updated
        assertEquals(300.0, homeState.energyUsage, 0.01);
        assertTrue(remoteAccessApp.getCommandHistory().contains("increase energy usage"));

        // Print the command history for debugging
        System.out.println("Command History: " + remoteAccessApp.getCommandHistory());

        // Verify the display output
        String expectedDisplay = "Home System Status:\n" +
                "Motion Detected: No\n" +
                "Room Occupied: No\n" +
                "Light Level: 0\n" +
                "Lights On: No\n" +
                "Temperature: 0°C\n" +
                "Energy Usage: 300.0 watts";

        String actualDisplay = remoteAccessApp.displayCurrentState();
        System.out.println("Actual Display: " + actualDisplay);  // Print display output for debugging
        assertEquals(expectedDisplay, actualDisplay);
    }
}

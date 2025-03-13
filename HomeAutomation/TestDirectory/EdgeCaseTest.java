import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EdgeCaseTest {

    @Test
    void testInvalidVoiceCommand() {
        HomeState homeState = new HomeState();
        RemoteAccessApp remoteAccessApp = new RemoteAccessApp(homeState);

        // Simulate an invalid voice command
        String result = remoteAccessApp.remoteControl("invalid command", homeState);

        // Debug print statement to check the result
        System.out.println("Result of invalid command: " + result);

        // Assert that the system handles invalid command gracefully
        assertEquals("ERROR: Unrecognized command!", result);
    }

    @Test
    void testEmptyMessageInEnergyObserver() {
        EnergyObserver observer = new EnergyObserver();

        // Simulate an empty message update
        observer.update("");

        // Debug print statement to verify power usage
        System.out.println("Total Usage after empty message: " + observer.getTotalUsage());

        // Since the message is empty, no power usage should be set
        assertEquals(0, observer.getTotalUsage());
    }
}

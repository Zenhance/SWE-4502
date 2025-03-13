import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDateTime;

public class MotionDetectorTest {

    private EnvironmentMonitor monitor;
    private MotionDetector motionDetector;

    @Before
    public void setUp() {
        monitor = new EnvironmentMonitor();
        motionDetector = new MotionDetector("Living Room");
        monitor.registerObserver(motionDetector);
    }

    // ✅ Test 1: Monitor and Respond to Motion Data
    @Test
    public void testMotionDetection() {
        EnvironmentState state = new EnvironmentState(22.0, true, 50.0);
        monitor.setState(state); // Trigger motion detection

        assertEquals(1, motionDetector.motionEvents.size()); // Verify one motion event is logged
    }

    // ✅ Test 2: Track Location and Time of Detected Movements
    @Test
    public void testMotionEventDetails() {
        EnvironmentState state = new EnvironmentState(22.0, true, 50.0);
        monitor.setState(state);

        MotionEvent event = motionDetector.motionEvents.get(0);
        assertEquals("Living Room", event.location); // Check location
        assertNotNull(event.timestamp); // Ensure timestamp is recorded
    }

    // ✅ Test 3: Log Activity and Analyze Patterns
    @Test
    public void testSuspiciousActivityDetection() {
        // Simulate a motion event during suspicious hours (e.g., 3 AM)
        motionDetector.motionEvents.add(new MotionEvent("Living Room", LocalDateTime.of(2025, 3, 14, 3, 0)));

        // Simulate a normal motion event at 10 AM
        motionDetector.motionEvents.add(new MotionEvent("Living Room", LocalDateTime.of(2025, 3, 14, 10, 0)));

        assertTrue(motionDetector.isSuspiciousActivity()); // Should detect as suspicious due to 3 AM activity
    }
}

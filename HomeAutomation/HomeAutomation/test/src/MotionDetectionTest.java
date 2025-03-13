import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MotionDetectionTest {
    @Test
    void testMotionDetection() {
        MotionDetector motionDetector = new MotionDetector();
        EnvironmentState state = new EnvironmentState();

        state.updateState("motion", true);

        motionDetector.update(state);

        assertTrue(motionDetector.isMotionDetected(), "Motion should be detected");
    }
}

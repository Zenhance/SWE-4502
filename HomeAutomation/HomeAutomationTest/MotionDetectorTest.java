import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MotionDetectorTest {
    public SystemStateManager state;
    public MotionDetector motionDetector;
    public SystemState initialState;
    @BeforeEach
    public void setup() {
        state = new SystemStateManager();
        motionDetector = new MotionDetector();
        state.registerObserver(motionDetector);
        initialState = new SystemState();
    }

    @Test
    public void testMotionDetection() {
        initialState.motionDetected =true;
        state.setState(initialState);
        assertTrue(motionDetector.isMotionDetected());
    }

    @Test
    public void testNoMotionDetection() {
        initialState.motionDetected =false;
        state.setState(initialState);
        assertFalse(motionDetector.isMotionDetected());
    }
}

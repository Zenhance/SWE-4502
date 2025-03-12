import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MotionDetectorTest
{

    @Test
    public void testMotionDetection()
    {
        MotionDetector motionDetector = new MotionDetector();
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.setMotionDetected(true);

        motionDetector.update(environmentState);
        assertTrue(motionDetector.isMotionDetected());
    }

    @Test
    public void testNoMotion()
    {
        MotionDetector motionDetector = new MotionDetector();
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.setMotionDetected(false);

        motionDetector.update(environmentState); // Simulate no motion
        assertFalse(motionDetector.isMotionDetected());
    }

    // Edge Case: Test motion detection with boundary value
    @Test
    public void testEdgeCaseMotion()
    {
        MotionDetector motionDetector = new MotionDetector();
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.setMotionDetected(true);

        motionDetector.update(environmentState); // Simulate motion detected
        assertTrue(motionDetector.isMotionDetected(), "Motion should be detected.");
    }
}


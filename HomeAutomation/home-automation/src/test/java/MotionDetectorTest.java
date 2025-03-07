import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import observers.MotionDetector;
import subjects.HomeAutomationSystem;
import models.EnvironmentState;

public class MotionDetectorTest {
    // Mock Instances
    @Mock
    private MotionDetector mockMotionDetector;
    // Actual Instances
    private MotionDetector motionDetector;
    private HomeAutomationSystem homeAutomationSystem;

    @BeforeEach
    void setUp(){
        homeAutomationSystem = new HomeAutomationSystem();
        mockMotionDetector = mock(MotionDetector.class);
        motionDetector = new MotionDetector();
        homeAutomationSystem.registerObserver(mockMotionDetector);
        homeAutomationSystem.registerObserver(motionDetector);
    }

    @Test
    public void testUpdateMethodCalled() {
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.setMotionDetected(true);
        homeAutomationSystem.setEnvironmentState(environmentState);
        verify(mockMotionDetector).update(any());
    }

    @Test
    void testMotionDetected(){
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.setMotionDetected(true);
        homeAutomationSystem.setEnvironmentState(environmentState);
        assertTrue(motionDetector.isMotionDetected());
    }

    @Test
    void testMotionNotDetected(){
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.setMotionDetected(false);
        homeAutomationSystem.setEnvironmentState(environmentState);
        assertFalse(motionDetector.isMotionDetected());
    }
}

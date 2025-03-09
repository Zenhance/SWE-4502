package Lab_11_210042166.Issue_2.Unit_Test;
import Lab_11_210042166.Issue_2.MotionDetect_Class.MotionDetector;
import Lab_11_210042166.Project_Structure.Interface.Component;
import Lab_11_210042166.Project_Structure.StateManager_Class.StateManager;
import Lab_11_210042166.Project_Structure.Storage_Class.EnvironmentState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



public class MotionDetectorTest {
    private StateManager stateManager;
    private MotionDetector motionDetector;
    private Component mockComponent;

    @BeforeEach
    void setUp() {
        stateManager = new StateManager();
        mockComponent = Mockito.mock(Component.class);
        stateManager.registerComponent(mockComponent);

        motionDetector = new MotionDetector(stateManager);
    }

    @Test
    void testSuspiciousActivityDetection() {

        for (int i = 0; i < 6; i++) {
            EnvironmentState testState = new EnvironmentState(0.0, true, 0);  // Motion detected
            stateManager.updateState(testState);
        }

        assertTrue(motionDetector.hasSuspiciousActivity(), "Suspicious activity should be detected");
    }
    @Test
    void testNoSuspiciousActivityWithFewMotions() {
        // Simulate a few motions
        for (int i = 0; i < 5; i++) {
            EnvironmentState testState = new EnvironmentState(0.0, true, 0);  // Motion detected
            stateManager.updateState(testState);
        }

        assertFalse(motionDetector.hasSuspiciousActivity(), "Suspicious activity should not be detected with few motions");
    }

}

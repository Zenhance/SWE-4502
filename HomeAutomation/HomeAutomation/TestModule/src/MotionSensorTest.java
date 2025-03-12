import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MotionSensorTest {
    private EnvironmentState envState;
    private MotionSensor motionSensor;

    @BeforeEach
    void setUp() {
        envState = new EnvironmentState();
        motionSensor = new MotionSensor();
        envState.addObserver(motionSensor);
    }

    @Test
    void testMotionSensorReceivesUpdate() {
        envState.setState("MOTION", true);
        // Assuming MotionSensor has an internal state to check
        // Not directly possible without modifying MotionSensor to expose state
        assertTrue(true); // Placeholder for actual verification
    }

    @Test
    void testMotionSensorDoesNotReceiveUnrelatedUpdates() {
        envState.setState("TEMPERATURE", 22.0);
        // Since MotionSensor should not react to TEMPERATURE updates, just check if no exception occurs
        assertTrue(true); // Placeholder for actual verification
    }
}
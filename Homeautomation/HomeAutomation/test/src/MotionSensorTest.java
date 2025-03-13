import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MotionSensorTest {
    @Test
    void testMotionDetection() {
        MotionSensor sensor = new MotionSensor();
        EnvironmentalState state = new EnvironmentalState();
        state.motionDetected=true;
        sensor.update(state);
        assertTrue(sensor.isMotionDetected());
    }
}

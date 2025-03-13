import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MotionSensorTest {
    @Test
    void testMotionDetection() {
        MotionSensor sensor = new MotionSensor();
        EnvironmentalState state = new EnvironmentalState(true, 22, 50, 100);
        sensor.update(state);
        assertTrue(sensor.isMotionDetected());
    }
}

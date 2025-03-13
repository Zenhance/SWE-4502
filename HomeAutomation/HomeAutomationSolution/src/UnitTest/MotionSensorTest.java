package UnitTest;
import CoreFramework.*;
import MotionDetection.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class MotionSensorTest {
    private MotionSensor sensor;
    private EnvironmentMonitor monitor;

    @BeforeEach
    void setUp() {
        sensor = new MotionSensor();
        monitor = new EnvironmentMonitor();
        monitor.registerObserver(sensor);
    }

    @Test
    void testMotionDetected() {
        monitor.setState(new EnvironmentState(true, 22, 75));

        List<MotionEvent> history = sensor.getMotionHistory();
        assertEquals(1, history.size(), "Motion event should be recorded.");
    }

    @Test
    void testNoMotionNoEvent() {
        monitor.setState(new EnvironmentState(false, 22, 75));

        assertTrue(sensor.getMotionHistory().isEmpty(), "No motion event should be recorded.");
    }
}

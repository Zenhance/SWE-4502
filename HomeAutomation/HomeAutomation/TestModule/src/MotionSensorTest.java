

import Components.MotionSensor;
import Core.EnvironmentState;
import Core.SmartHomeData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MotionSensorTest {
    private EnvironmentState envState;
    private SmartHomeData homeData;
    private MotionSensor motionSensor;

    @BeforeEach
    void setUp() {
        envState = new EnvironmentState();
        homeData = new SmartHomeData();
        motionSensor = new MotionSensor(homeData);
        envState.addObserver(motionSensor);
    }

    @Test
    void testMotionSensorReceivesUpdate() {
        envState.setState("MOTION", true);
        assertFalse(motionSensor.getActivityLog().isEmpty()); // Verifies motion is logged
    }

    @Test
    void testMotionSensorIgnoresUnrelatedUpdates() {
        envState.setState("TEMPERATURE", 21.0);
        assertTrue(motionSensor.getActivityLog().isEmpty()); // Ensures motion sensor ignores unrelated updates
    }
}

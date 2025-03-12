import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MotionObserverTest {
    @Test
    void testMultipleMotionEvents() {
        // Create motion detection system and observer
        MotionDetectionSystem motionSystem = new MotionDetectionSystem();
        MotionObserver observer = new MotionObserver();

        // Register observer
        motionSystem.registerObserver(observer);

        // Simulate multiple motion detections
        motionSystem.detectMotion("Living Room", "12:30 PM");
        motionSystem.detectMotion("Kitchen", "1:00 PM");
        motionSystem.detectMotion("Bedroom", "2:00 PM");

        // Assert the observer's last received location and time
        assertEquals("Bedroom", observer.getLastLocation());
        assertEquals("2:00 PM", observer.getLastTime());
    }

}

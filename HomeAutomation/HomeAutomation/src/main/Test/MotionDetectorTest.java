    // Motion Detection Component Tests
    package main.Test;

    import main.Code.components.MotionDetector;
    import core.EventType;
    import core.HomeSystem;
    import org.junit.Before;
    import org.junit.Test;

    import java.time.LocalDateTime;
    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

    import static org.junit.Assert.*;

    public class MotionDetectorTest {

        private MotionDetector motionDetector;
        private HomeSystem homeSystem;

        @Before
        public void setup() {
            homeSystem = HomeSystem.getInstance();
            homeSystem.reset(); // Clear state before each test

        }

        @Test
        public void testMotionDetection() {
            String location = "living_room";
            LocalDateTime timestamp = LocalDateTime.now();

            // Test motion detection
            motionDetector.detectMotion(location, timestamp);

            // Retrieve updated state from HomeSystem
            Map<String, Object> detectedMotion = (Map<String, Object>) homeSystem.getState("motion_detection");

            assertNotNull(detectedMotion);
            assertEquals(location, detectedMotion.get("location"));
            assertEquals(timestamp, detectedMotion.get("timestamp"));
        }

        @Test
        public void testMotionStatus() {
            // Simulate motion detection
            motionDetector.detectMotion("kitchen", LocalDateTime.now());

            assertTrue(motionDetector.isMotionDetected("kitchen"));
            assertFalse(motionDetector.isMotionDetected("bedroom"));
        }

        @Test
        public void testMotionHistory() {
            // Simulate motion history
            motionDetector.detectMotion("entrance", LocalDateTime.now().minusMinutes(5));
            motionDetector.detectMotion("living_room", LocalDateTime.now().minusMinutes(2));

            List<Map<String, Object>> history = motionDetector.getMotionHistory();

            assertEquals(2, history.size());
            assertEquals("entrance", history.get(0).get("location"));
            assertEquals("living_room", history.get(1).get("location"));
        }

        @Test
        public void testSuspiciousActivityDetection() {
            // Simulate motion patterns
            motionDetector.detectMotion("entrance", LocalDateTime.now());

            assertTrue(motionDetector.isActivitySuspicious("entrance"));
            assertFalse(motionDetector.isActivitySuspicious("living_room"));
        }

        @Test
        public void testObserverUpdate() {
            // Simulate system event update
            Map<String, Object> mockData = new HashMap<>();
            mockData.put("location", "bedroom");
            mockData.put("detected", true);

            motionDetector.update(EventType.MOTION_DETECTED, mockData);

            // Verify if detector updated state correctly
            assertTrue(motionDetector.isMotionDetected("bedroom"));
        }
    }

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Issue2Test {

    private StateManager stateManager;
    private MotionDetector motionDetector;
    private AlarmListener alarmListener;

    @Before
    public void setUp() {
        stateManager = new StateManager();
        motionDetector = new MotionDetector(stateManager);
        alarmListener = new AlarmListener();
        stateManager.registerComponent("alarm", alarmListener);
    }

    @Test

    public void testMotionDetection() {
        // Test motion detection event handling
        MotionEvent event = new MotionEvent(true, "living room", System.currentTimeMillis());
        stateManager.updateState("motion", event);

        assertTrue(motionDetector.isMotionDetected());
        assertEquals("living room", motionDetector.getLocation());
        assertEquals(event.getTimestamp(), motionDetector.getLastMotionTimestamp());
    }

    @Test
    public void testMotionEndDetection() {
        // Test motion ended event handling
        MotionEvent startEvent = new MotionEvent(true, "kitchen", System.currentTimeMillis());
        stateManager.updateState("motion", startEvent);

        MotionEvent endEvent = new MotionEvent(false, "kitchen", System.currentTimeMillis() + 5000);
        stateManager.updateState("motion", endEvent);

        assertFalse(motionDetector.isMotionDetected());
        assertEquals("kitchen", motionDetector.getLocation());
        assertEquals(endEvent.getTimestamp(), motionDetector.getLastMotionTimestamp());
    }

    @Test
    public void testSuspiciousMotionAlarm() {
        // Test suspicious motion detection
           MotionEvent event = new MotionEvent(true, "entry", System.currentTimeMillis());
        stateManager.updateState("motion", event);

        AlarmEvent alarmEvent = alarmListener.getLastAlarm();
        assertNotNull(alarmEvent);
        assertEquals("Suspicious motion detected in entry", alarmEvent.getMessage());



    }





}


package main.Test;

import core.EventType;
import core.HomeSystem;
import core.HomeSystemObserver;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class HomeSystemTest {

    private HomeSystem homeSystem;
    private TestObserver testObserver;

    @Before
    public void setup() {
        homeSystem = HomeSystem.getInstance();
        homeSystem.reset(); // Clear any previous state for clean tests
        testObserver = new TestObserver(); // Custom observer instead of Mockito
    }

    @Test
    public void testSingletonPattern() {
        HomeSystem instance1 = HomeSystem.getInstance();
        HomeSystem instance2 = HomeSystem.getInstance();
        assertSame("HomeSystem should be a singleton", instance1, instance2);
    }

    @Test
    public void testStateManagement() {
        // Test setting and getting state
        homeSystem.updateState("temperature_living_room", 22.5);
        homeSystem.updateState("light_level_kitchen", 80);

        assertEquals(22.5, homeSystem.getState("temperature_living_room"));
        assertEquals(80, homeSystem.getState("light_level_kitchen"));

        // Test full state retrieval
        Map<String, Object> fullState = homeSystem.getFullState();
        assertEquals(2, fullState.size());
        assertEquals(22.5, fullState.get("temperature_living_room"));
        assertEquals(80, fullState.get("light_level_kitchen"));
    }

    @Test
    public void testObserverRegistration() {
        // Register the custom observer
        homeSystem.registerObserver(EventType.TEMPERATURE_CHANGED, testObserver);
        homeSystem.registerObserver(EventType.MOTION_DETECTED, testObserver);

        // Create test events
        Map<String, Object> tempData = new HashMap<>();
        tempData.put("room", "living_room");
        tempData.put("temperature", 23.0);

        Map<String, Object> motionData = new HashMap<>();
        motionData.put("location", "entrance");
        motionData.put("detected", true);

        // Notify observers
        homeSystem.notifyObservers(EventType.TEMPERATURE_CHANGED, tempData);
        homeSystem.notifyObservers(EventType.MOTION_DETECTED, motionData);

        // Verify the observer was notified
        assertEquals(EventType.TEMPERATURE_CHANGED, testObserver.lastEvent);
        assertEquals(tempData, testObserver.lastData);

        homeSystem.notifyObservers(EventType.MOTION_DETECTED, motionData);
        assertEquals(EventType.MOTION_DETECTED, testObserver.lastEvent);
        assertEquals(motionData, testObserver.lastData);
    }

    @Test
    public void testObserverRemoval() {
        // Register the custom observer
        homeSystem.registerObserver(EventType.LIGHT_LEVEL_CHANGED, testObserver);

        // Remove the observer
        homeSystem.removeObserver(EventType.LIGHT_LEVEL_CHANGED, testObserver);

        // Create and send a test event
        Map<String, Object> lightData = new HashMap<>();
        lightData.put("room", "bedroom");
        lightData.put("level", 50);

        homeSystem.notifyObservers(EventType.LIGHT_LEVEL_CHANGED, lightData);

        // Observer should not be notified
        assertNull(testObserver.lastEvent);
        assertNull(testObserver.lastData);
    }

    // Custom Observer Class to Replace Mockito
    private static class TestObserver implements HomeSystemObserver {
        public EventType lastEvent;
        public Map<String, Object> lastData;

        @Override
        public void update(EventType eventType, Map<String, Object> data) {
            this.lastEvent = eventType;
            this.lastData = data;
        }
    }
}

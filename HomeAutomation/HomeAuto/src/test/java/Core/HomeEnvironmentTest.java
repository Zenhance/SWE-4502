package Core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeEnvironmentTest {
    private HomeEnvironment homeEnvironment;
    private TestObserver testObserver;

    // Custom observer implementation for testing
    private static class TestObserver implements Observer {
        private boolean updated = false;
        private String lastEventType;
        private Object lastValue;

        @Override
        public void update(String eventType, Object value) {
            this.updated = true;
            this.lastEventType = eventType;
            this.lastValue = value;
        }

        public boolean isUpdated() {
            return updated;
        }

        public String getLastEventType() {
            return lastEventType;
        }

        public Object getLastValue() {
            return lastValue;
        }

        public void reset() {
            this.updated = false;
            this.lastEventType = null;
            this.lastValue = null;
        }
    }

    @BeforeEach
    void setUp() {
        homeEnvironment = HomeEnvironment.getInstance();
        testObserver = new TestObserver();
    }

    // Test Singleton Pattern: Ensure only one instance of HomeEnvironment exists
    @Test
    void testSingletonInstance() {
        HomeEnvironment instance1 = HomeEnvironment.getInstance();
        HomeEnvironment instance2 = HomeEnvironment.getInstance();
        assertSame(instance1, instance2, "Instances should be the same (Singleton pattern)");
    }

    // Test Observer Registration and Notification
    @Test
    void testObserverRegistrationAndNotification() {
        homeEnvironment.registerObserver("testEvent", testObserver);

        // Change the state for "testEvent"
        homeEnvironment.setState("testEvent", "TestValue");

        // Verify that the observer's update method was called
        assertTrue(testObserver.isUpdated(), "Observer should have been notified");
        assertEquals("testEvent", testObserver.getLastEventType(), "Observer should be notified for 'testEvent'");
        assertEquals("TestValue", testObserver.getLastValue(), "Observer should receive the correct value");
    }

    // Test that observers are only notified for the correct event type
    @Test
    void testObserverNotificationForCorrectEvent() {
        homeEnvironment.registerObserver("testEvent", testObserver);

        // Set the state for "testEvent"
        homeEnvironment.setState("testEvent", "TestValue");

        // Observer should be notified for "testEvent"
        assertTrue(testObserver.isUpdated(), "Observer should be notified for 'testEvent'");
        assertEquals("TestValue", testObserver.getLastValue(), "Observer should receive the correct value");

        // Reset observer and change state for a different event type
        testObserver.reset();
        homeEnvironment.setState("anotherEvent", "AnotherValue");

        // Observer should not be notified for "anotherEvent"
        assertFalse(testObserver.isUpdated(), "Observer should not be notified for 'anotherEvent'");
    }

    // Test Observer Removal: Ensure observers are not notified after being removed
    @Test
    void testObserverRemoval() {
        homeEnvironment.registerObserver("testEvent", testObserver);

        // Remove the observer for "testEvent"
        homeEnvironment.removeObserver("testEvent", testObserver);

        // Change the state for "testEvent"
        homeEnvironment.setState("testEvent", "NewTestValue");

        // Observer should not be notified after removal
        assertFalse(testObserver.isUpdated(), "Observer should not be notified after removal");
    }

    // Test State Management: Ensure state can be set and retrieved correctly
    @Test
    void testStateManagement() {
        // Set the state for "temperature"
        homeEnvironment.setState("temperature", 22);

        // Retrieve and verify the state for "temperature"
        assertEquals(22, homeEnvironment.getState("temperature"), "State should be correctly stored and retrieved");

        // Set the state for "lightState"
        homeEnvironment.setState("lightState", "on");

        // Retrieve and verify the state for "lightState"
        assertEquals("on", homeEnvironment.getState("lightState"), "State should be correctly stored and retrieved");
    }
}

import static org.junit.jupiter.api.Assertions.*;

import CoreFramework.Observer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import CoreFramework.HomeEnvironment;


class HomeEnvironmentTest {
    private HomeEnvironment homeEnvironment;
    private TestObserver testObserver;

    static class TestObserver implements Observer {
        private boolean updated = false;
        private Object lastValue;

        @Override
        public void update(String eventType, Object value) {
            updated = true;
            lastValue = value;
        }

        public boolean isUpdated() {
            return updated;
        }

        public Object getLastValue() {
            return lastValue;
        }
    }

    @BeforeEach
    void setUp() {
        homeEnvironment = HomeEnvironment.getInstance();
        testObserver = new TestObserver();
    }

    @Test
    void testSingletonInstance() {
        HomeEnvironment instance1 = HomeEnvironment.getInstance();
        HomeEnvironment instance2 = HomeEnvironment.getInstance();
        assertSame(instance1, instance2, "Instances should be the same (Singleton pattern)");
    }

    @Test
    void testObserverRegistrationAndNotification() {
        homeEnvironment.registerObserver("testEvent", testObserver);
        homeEnvironment.setState("testEvent", "TestValue");

        assertTrue(testObserver.isUpdated(), "Observer should have been notified");
        assertEquals("TestValue", testObserver.getLastValue(), "Observer should receive the correct value");
    }

    @Test
    void testObserverRemoval() {
        homeEnvironment.registerObserver("testEvent", testObserver);
        homeEnvironment.removeObserver("testEvent", testObserver);
        homeEnvironment.setState("testEvent", "NewValue");

        assertFalse(testObserver.isUpdated(), "Observer should not be notified after removal");
    }

    @Test
    void testStateManagement() {
        homeEnvironment.setState("temperature", 22);
        assertEquals(22, homeEnvironment.getState("temperature"), "State should be correctly stored and retrieved");
    }

}
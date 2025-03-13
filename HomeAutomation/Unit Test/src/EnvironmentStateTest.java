import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Define the test class
class EnvironmentStateTest {

    private EnvironmentState environmentState;
    private Observer mockObserver;

    // Stub Observer class for testing
    static class StubObserver implements Observer {
        private String state;
        private Object value;

        @Override
        public void update(String state, Object value) {
            this.state = state;
            this.value = value;
        }

        public String getState() {
            return state;
        }

        public Object getValue() {
            return value;
        }
    }

    // Set up before each test
    @BeforeEach
    void setUp() {
        environmentState = new EnvironmentState();  // Initialize the class under test
        mockObserver = new StubObserver();  // Using stub instead of mock
    }

    @Test
    void testAddObserver() {
        // Add observer and assert it is in the observers list
        environmentState.addObserver(mockObserver);
        assertTrue(environmentState.getObservers().contains(mockObserver), "Observer should be added");
    }

    @Test
    void testRemoveObserver() {
        // Add and then remove an observer
        environmentState.addObserver(mockObserver);
        environmentState.removeObserver(mockObserver);

        // Ensure the observer is removed
        assertFalse(environmentState.getObservers().contains(mockObserver), "Observer should be removed");
    }

    @Test
    void testSetStateAndNotify() {
        // Add the observer and set state
        environmentState.addObserver(mockObserver);
        environmentState.setState("Temperature", 25);

        // Verify that the observer was notified with correct state and value
        assertEquals("Temperature", ((StubObserver) mockObserver).getState());
        assertEquals(25, ((StubObserver) mockObserver).getValue());
    }

    @Test
    void testNotifyObservers() {
        // Add multiple observers
        Observer secondObserver = new StubObserver();
        environmentState.addObserver(mockObserver);
        environmentState.addObserver(secondObserver);

        // Set the state to trigger notifications
        environmentState.setState("Humidity", 70);

        // Verify both observers were notified
        assertEquals("Humidity", ((StubObserver) mockObserver).getState());
        assertEquals(70, ((StubObserver) mockObserver).getValue());

        assertEquals("Humidity", ((StubObserver) secondObserver).getState());
        assertEquals(70, ((StubObserver) secondObserver).getValue());
    }
}

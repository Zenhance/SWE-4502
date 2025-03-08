package core;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.Measurement;
import model.Measurement.Units;
import testutils.MockEventListener;

public class StateManagerTest {

    @Test
    void testRegisterAndPublishEvent() {
        StateManager stateManager = new StateManager();
        MockEventListener listener = new MockEventListener();
        EventType testEventType = EventType.TEMPERATURE;

        stateManager.register(testEventType, listener);
        Measurement initialMeasurement = new Measurement(20, Units.CELSIUS);
        stateManager.setState(testEventType, initialMeasurement);

        assertNotNull(listener.getReceivedEvent(), "Listener should have received an event");
        assertEquals(testEventType, listener.getReceivedEvent().getType(), "Event type should match");
        assertEquals(initialMeasurement, stateManager.getState(testEventType), "State should be updated");
    }

    @Test
    void testRemoveEventListener() {
        StateManager stateManager = new StateManager();
        MockEventListener listener = new MockEventListener();
        EventType testEventType = EventType.LIGHT_LEVEL;

        stateManager.register(testEventType, listener);
        stateManager.remove(testEventType, listener);
        Measurement initialMeasurement = new Measurement(20, Units.CELSIUS);
        stateManager.setState(testEventType, initialMeasurement);

        assertNull(listener.getReceivedEvent(), "Listener should not have received an event after removal");
    }

    @Test
    void testSetAndGetState() {
        StateManager stateManager = new StateManager();
        EventType testEventType = EventType.MOTION;
        Measurement initialMeasurement = new Measurement(1, Units.COUNT);

        stateManager.setState(testEventType, initialMeasurement);
        Measurement retrievedState = stateManager.getState(testEventType);

        assertEquals(initialMeasurement, retrievedState, "Retrieved state should match the set state");
    }

    @Test
    void testPublishEventToMultipleListeners() {
        StateManager stateManager = new StateManager();
        MockEventListener listener1 = new MockEventListener();
        MockEventListener listener2 = new MockEventListener();
        EventType testEventType = EventType.TEMPERATURE;

        stateManager.register(testEventType, listener1);
        stateManager.register(testEventType, listener2);
        Measurement initialMeasurement = new Measurement(20, Units.CELSIUS);
        stateManager.setState(testEventType, initialMeasurement);

        assertNotNull(listener1.getReceivedEvent(), "Listener1 should have received an event");
        assertNotNull(listener2.getReceivedEvent(), "Listener2 should have received an event");
        assertEquals(testEventType, listener1.getReceivedEvent().getType(), "Listener1 event type should match");
        assertEquals(testEventType, listener2.getReceivedEvent().getType(), "Listener2 event type should match");
    }
}

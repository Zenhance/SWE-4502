package core.testutils;

import core.Event;
import core.EventListener;

public class MockEventListener implements EventListener {
    private Event receivedEvent;

    @Override
    public void onEvent(Event event) {
        this.receivedEvent = event;
    }

    public Event getReceivedEvent() {
        return receivedEvent;
    }
}

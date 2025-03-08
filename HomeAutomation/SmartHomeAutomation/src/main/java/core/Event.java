package java.core;

public class Event {
    private EventType type;
    private Object data;

    public Event(EventType type, Object data) {
        this.type = type;
        this.data = data;
    }

    public EventType getType() {
        return type;
    }

    public Object getData() {
        return data;
    }
}

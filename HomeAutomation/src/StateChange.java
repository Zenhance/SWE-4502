
public class StateChange {
    private String name;
    private Object value;

    public StateChange(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() { return name; }
    public Object getValue() { return value; }
}
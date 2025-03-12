import java.util.HashMap;
import java.util.Map;

public class StateData
{
    private Map<String, Object> states = new HashMap<>();

    public void addEnvironmentState(String key, EnvironmentState state) {
        states.put(key, state);
    }

    public EnvironmentState getEnvironmentState(String key) {
        return (EnvironmentState) states.getOrDefault(key, null);
    }

    public void addSystemState(String key, SystemState state) {
        states.put(key, state);
    }

    public SystemState getSystemState(String key) {
        return (SystemState) states.getOrDefault(key, null);
    }
}

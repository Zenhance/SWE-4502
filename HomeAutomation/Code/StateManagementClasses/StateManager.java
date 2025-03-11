package Code.StateManagementClasses;

import Code.Interfaces.Component;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StateManager {
    private Map<String, Object> state = new HashMap<>();
    private Set<Component> components = new HashSet<>();

    public void registerComponent(Component component) {
        components.add(component);
    }

    public void updateState(String key, Object value) {
        state.put(key, value);
        notifyComponents(key, value);
    }

    public Object getState(String key) {
        return state.get(key);
    }

    public Set<Component> getComponents() {
        return components;
    }

    private void notifyComponents(String key, Object value) {
        for (Component component : components) {
            component.onStateChange(key, value);
        }
    }
}
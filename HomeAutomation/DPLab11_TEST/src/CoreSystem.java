import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class CoreSystem {
    private Map<String, Integer> environmentStates;
    private Set<Component> registeredComponents;

    public CoreSystem() {
        environmentStates = new HashMap<>();
        registeredComponents = new HashSet<>();
    }

    public void registerComponent(Component component) {
        registeredComponents.add(component);
    }

    public void changeState(String state, int value) {
        environmentStates.put(state, value);
        notifyComponents(state, value);
    }

    public int getState(String state) {
        return environmentStates.getOrDefault(state, 0);
    }

    private void notifyComponents(String state, int value) {
        for (Component component : registeredComponents) {
            component.onStateChange(state, value);
        }
    }
}

class Component {
    private String name;
    private boolean notified;

    public Component(String name) {
        this.name = name;
        this.notified = false; // Initially, the component is not notified
    }

    public void onStateChange(String state, int value) {
        System.out.println("Component " + name + " notified of state change: " + state + " = " + value);
        this.notified = true;
    }

    public boolean isNotified() {
        return notified;
    }
}

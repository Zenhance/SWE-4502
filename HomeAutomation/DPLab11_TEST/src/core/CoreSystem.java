package core;

import java.util.HashSet;
import java.util.Set;

public class CoreSystem {
    private static CoreSystem instance;
    private Set<IComponent> components;
    private String environmentState;

    public CoreSystem() {
        components = new HashSet<>();
    }

    public static CoreSystem getInstance() {
        if (instance == null) {
            instance = new CoreSystem();
        }
        return instance;
    }

    public void registerComponent(IComponent component) {
        components.add(component);
    }

    public void updateState(String newState) {
        this.environmentState = newState;
        notifyComponents();
    }

    private void notifyComponents() {
        for (IComponent component : components) {
            component.onStateChanged(environmentState, 0);
        }
    }

    public String getEnvironmentState() {
        return environmentState;
    }
}

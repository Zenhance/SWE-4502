package Code.Controllers;

import Code.StateManagementClasses.StateManager;
import Code.Interfaces.Component;

public class CoreSystem {
    private StateManager stateManager;

    public CoreSystem(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    public void registerComponent(Component component) {
        stateManager.registerComponent(component);
    }

    public void updateState(String key, Object value) {
        stateManager.updateState(key, value);
    }
}
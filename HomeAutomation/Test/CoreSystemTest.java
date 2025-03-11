package Test;

import org.junit.jupiter.api.Test;
import Code.StateManagementClasses.StateManager;
import Code.Controllers.CoreSystem;
import Code.Interfaces.Component;
import static org.junit.jupiter.api.Assertions.*;

class CoreSystemTest {

    @Test
    void testRegisterComponent() {
        StateManager stateManager = new StateManager();
        CoreSystem coreSystem = new CoreSystem(stateManager);
        Component component = new TestComponent();

        coreSystem.registerComponent(component);

        assertTrue(stateManager.getComponents().contains(component));
    }

    @Test
    void testUpdateState() {
        StateManager stateManager = new StateManager();
        CoreSystem coreSystem = new CoreSystem(stateManager);

        coreSystem.updateState("temperature", 22.5);

        assertEquals(22.5, stateManager.getState("temperature"));
    }

    private static class TestComponent implements Component {
        @Override
        public void onStateChange(String key, Object value) {
            // Do nothing for testing
        }
    }
}
package Lab_11_210042166.Issue_1.Unit_Test;

import Lab_11_210042166.Project_Structure.Interface.Component;
import Lab_11_210042166.Project_Structure.StateManager_Class.StateManager;
import Lab_11_210042166.Project_Structure.Storage_Class.EnvironmentState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
public class StateManagerTest {
    private StateManager stateManager;
    private Component mockComponent;

    @BeforeEach
    void setUp() {
        stateManager = new StateManager();
        mockComponent = Mockito.mock(Component.class);
        stateManager.registerComponent(mockComponent);
    }

    @Test
    void testStateUpdateNotifiesComponents() {
        EnvironmentState testState = new EnvironmentState(25.0, true, 70);
        stateManager.updateState(testState);

        verify(mockComponent, times(1)).update(testState);
    }

    @Test
    void testUnregisterComponentStopsReceivingUpdates() {
        stateManager.unregisterComponent(mockComponent);

        EnvironmentState testState = new EnvironmentState(30.0, false, 50);
        stateManager.updateState(testState);

        verify(mockComponent, never()).update(testState);
    }
}

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

public class CoreSystemTest {

    private CoreSystem coreSystem;
    private Component componentA;
    private Component componentB;

    @Before
    public void setUp() {
        coreSystem = new CoreSystem(); // Initialize CoreSystem before each test
        componentA = new Component("ComponentA");
        componentB = new Component("ComponentB");
    }

    @Test
    public void testRegisterComponent() {
        // Register the component
        coreSystem.registerComponent(componentA);

        // Verify the component is added to the system
        assertTrue("Component should be registered", coreSystem.getState("ComponentA") == 0);  // Initial state
    }

    @Test
    public void testChangeStateAndNotify() {
        // Register components
        coreSystem.registerComponent(componentA);
        coreSystem.registerComponent(componentB);

        // Change state and trigger notification to components
        coreSystem.changeState("temperature", 25);

        // Verify that the state has been correctly set in the environment
        assertEquals("State should be 25", 25, coreSystem.getState("temperature"));

        // Verify that both components were notified
        assertTrue("ComponentA should be notified", componentA.isNotified());
        assertTrue("ComponentB should be notified", componentB.isNotified());
    }

    @Test
    public void testGetState() {
        // Change state in the system
        coreSystem.changeState("humidity", 75);

        // Verify that the state value is correctly retrieved
        assertEquals("State humidity should be 75", 75, coreSystem.getState("humidity"));
    }

    @Test
    public void testStateChangeWithoutNotificationForUnregisteredComponent() {
        // Only register one component
        coreSystem.registerComponent(componentA);

        // Change state
        coreSystem.changeState("pressure", 1000000);

        // Verify that only the registered component is notified
        assertTrue("ComponentA should be notified", componentA.isNotified());
        assertFalse("ComponentB should not be notified", componentB.isNotified());
    }
}

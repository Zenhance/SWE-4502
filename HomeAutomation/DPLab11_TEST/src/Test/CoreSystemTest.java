import core.CoreSystem;
import components.HomeComponent;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CoreSystemTest {

    private CoreSystem coreSystem;
    private HomeComponent componentA;
    private HomeComponent componentB;

    @Before
    public void setUp() {
        coreSystem = CoreSystem.getInstance(); // Initialize CoreSystem before each test
        componentA = new HomeComponent("ComponentA");
        componentB = new HomeComponent("ComponentB");
    }

    @Test
    public void testRegisterComponent() {
        // Register the component
        coreSystem.registerComponent(componentA);

        // Verify that the component is registered by checking if it's notified
        assertFalse("Component should not be notified initially", componentA.isNotified());

        // Change state and check if the component gets notified
        coreSystem.updateState("temperature");

        // Verify the component gets notified when the state changes
        assertTrue("Component should be notified", componentA.isNotified());
    }

    @Test
    public void testChangeStateAndNotify() {
        // Register components
        coreSystem.registerComponent(componentA);
        coreSystem.registerComponent(componentB);

        // Change state and trigger notification to components
        coreSystem.updateState("temperature");

        // Verify that the state has been correctly set in the environment
        assertEquals("State should be 'temperature'", "temperature", coreSystem.getEnvironmentState());

        // Verify that both components were notified
        assertTrue("ComponentA should be notified", componentA.isNotified());
        assertTrue("ComponentB should be notified", componentB.isNotified());
    }

    @Test
    public void testGetState() {
        // Change state in the system
        coreSystem.updateState("humidity");

        // Verify that the state value is correctly retrieved
        assertEquals("State humidity should be 'humidity'", "humidity", coreSystem.getEnvironmentState());
    }

    @Test
    public void testStateChangeWithoutNotificationForUnregisteredComponent() {
        // Only register one component
        coreSystem.registerComponent(componentA);

        // Change state
        coreSystem.updateState("pressure");

        // Verify that only the registered component is notified
        assertTrue("ComponentA should be notified", componentA.isNotified());
        assertFalse("ComponentB should not be notified", componentB.isNotified());
    }
}

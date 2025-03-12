import Issue1.StateManager;
import Issue1.TestComponent;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Issue1Test {

    private StateManager stateManager;


    private TestComponent component;

    @Before
    public void setUp() {

        stateManager = new StateManager();

        component = new TestComponent();

        };


    @Test
    public void testRegisterComponent() {

        stateManager.registerComponent("key", component);

        stateManager.updateState("key", "value");

        assertEquals("key", component.getLastUpdatedKey());
        assertEquals("value", component.getLastUpdatedValue());



    }

    @Test
    public void testRemoveComponent() {

        stateManager.registerComponent("key", component);

        stateManager.removeComponent("key", component);


        assertEquals(null, component.getLastUpdatedKey());
        assertEquals(null, component.getLastUpdatedValue());

    }

    @Test
    public void testUpdateState() {

        stateManager.registerComponent("key", component);

        stateManager.updateState("key", "value");

        assertEquals("key", component.getLastUpdatedKey());
        assertEquals("value", component.getLastUpdatedValue());

    }







    }






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








    }






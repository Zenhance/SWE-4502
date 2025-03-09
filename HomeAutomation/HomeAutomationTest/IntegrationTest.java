import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntegrationTest {
    public SystemStateManager sysState;
    public SystemState state;
    public RemoteAccessApp remoteAccessApp;
    public LightManager lightManager;


    @BeforeEach
    public void setup() {
        sysState = new SystemStateManager();
        remoteAccessApp = new RemoteAccessApp(sysState);
        state = new SystemState();

        lightManager = new LightManager();
        sysState.registerObserver(lightManager);
    }

    @Test
    public void testRemoteControlAffectsSystemState() {
        remoteAccessApp.remoteControl("turn on the lights");
        assertTrue(sysState.state.setLightsOn);
    }

    @Test
    public void testObserversReactToStateChange() {
        state.lightLevel = 20;
        state.roomOccupied = true;
        sysState.setState(state);

        assertEquals(70, lightManager.getChangedLightLevel());
    }

    @Test
    public void testNotificationsTriggeredOnStateChange() {
        String notification = remoteAccessApp.remoteControl("set my cgpa as 4.00");
        assertEquals("ERROR: Unrecognized command!", notification);
    }
}

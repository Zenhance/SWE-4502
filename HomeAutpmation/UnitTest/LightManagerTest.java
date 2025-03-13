import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LightManagerTest {

    private LightManager lightManager;
    private SystemState systemState;

    @BeforeEach
    public void setUp() {
        lightManager = new LightManager();
        systemState = new SystemState();
    }
    @Test
    public void testDarkStateTurnsOnLights() {
        systemState.setStateDescription("Dark");
        lightManager.update(systemState);
        assertEquals("It's dark, turning on the lights...", lightManager.getLastAction());
    }


    @Test
    public void testBrightStateTurnsOffLights() {
        systemState.setStateDescription("Bright");
        lightManager.update(systemState);
        assertEquals("It's bright, turning off the lights...", lightManager.getLastAction());
    }


    @Test
    public void testRoomOccupiedSetsReadingScene() {
        systemState.setStateDescription("Room Occupied");
        lightManager.update(systemState);
        assertEquals("Setting lighting scene to Reading.", lightManager.getLastAction());
    }

    @Test
    public void testRoomUnoccupiedTurnsOffLights() {
        systemState.setStateDescription("Room Unoccupied");
        lightManager.update(systemState);
        assertEquals("Turning off the lights...", lightManager.getLastAction());
    }


}

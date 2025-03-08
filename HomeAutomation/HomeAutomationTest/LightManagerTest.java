import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LightManagerTest {
    private LightManager lightManager;
    private SystemState state;

    @BeforeEach
    public void setup() {
        lightManager = new LightManager();
        state = new SystemState();
    }

    @Test
    public void testLightAdjustmentWhenRoomOccupiedAndLightLow() {
        state.lightLevel = 20;
        state.roomOccupied = true;
        lightManager.update(state);

        assertEquals(70, lightManager.getChangedLightLevel());
        assertEquals("Reading", lightManager.getScene());
    }

    @Test
    public void testLightAdjustmentWhenRoomOccupiedAndLightMedium() {
        state.lightLevel = 50;
        state.roomOccupied = true;
        lightManager.update(state);

        assertEquals(60, lightManager.getChangedLightLevel());
        assertEquals("Normal", lightManager.getScene());
    }

    @Test
    public void testLightAdjustmentWhenRoomOccupiedAndLightHigh() {
        state.lightLevel = 80;
        state.roomOccupied = true;
        lightManager.update(state);

        assertEquals(30, lightManager.getChangedLightLevel());
        assertEquals("Movie", lightManager.getScene());
    }

    @Test
    public void testLightAdjustmentWhenRoomUnoccupied() {
        state.lightLevel = 50;
        state.roomOccupied = false;
        lightManager.update(state);

        assertEquals(0, lightManager.getChangedLightLevel());
        assertEquals("Off", lightManager.getScene());
    }
}
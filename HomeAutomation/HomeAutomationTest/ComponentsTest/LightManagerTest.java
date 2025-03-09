package ComponentsTest;

import static org.junit.jupiter.api.Assertions.*;

import Components.LightManager;
import Core_Models.SystemState;
import Core_Models.SystemStateManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LightManagerTest {
    private LightManager lightManager;
    public SystemStateManager sysState;
    private SystemState state;

    @BeforeEach
    public void setup() {
        lightManager = new LightManager();
        state = new SystemState();
        sysState = new SystemStateManager();
        sysState.registerObserver(lightManager);
    }

    @Test
    public void testLightAdjustmentWhenRoomOccupiedAndLightLow() {
        state.lightLevel = 20;
        state.roomOccupied = true;
        sysState.setState(state);

        assertEquals(70, lightManager.getChangedLightLevel());
        assertEquals("Reading", lightManager.getScene());
    }

    @Test
    public void testLightAdjustmentWhenRoomOccupiedAndLightMedium() {
        state.lightLevel = 50;
        state.roomOccupied = true;
        sysState.setState(state);

        assertEquals(60, lightManager.getChangedLightLevel());
        assertEquals("Normal", lightManager.getScene());
    }

    @Test
    public void testLightAdjustmentWhenRoomOccupiedAndLightHigh() {
        state.lightLevel = 80;
        state.roomOccupied = true;
        sysState.setState(state);

        assertEquals(30, lightManager.getChangedLightLevel());
        assertEquals("Movie", lightManager.getScene());
    }

    @Test
    public void testLightAdjustmentWhenRoomUnoccupied() {
        state.lightLevel = 50;
        state.roomOccupied = false;
        sysState.setState(state);

        assertEquals(0, lightManager.getChangedLightLevel());
        assertEquals("Off", lightManager.getScene());
    }
}
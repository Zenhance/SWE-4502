package Test;

import org.junit.jupiter.api.Test;
import Code.Controllers.LightManager;
import Code.StateManagementClasses.StateManager;

import static org.junit.jupiter.api.Assertions.*;

class LightManagerTest {

    @Test
    void testAdjustLighting_LowLight() {
        StateManager stateManager = new StateManager();
        LightManager lightManager = new LightManager(stateManager);

        lightManager.onStateChange("occupancy", true);
        lightManager.onStateChange("lightLevel", 10.0);

        assertTrue(lightManager.isOccupied(), "Room should be occupied.");
    }

    // ✅ Test Lighting Scene Change
    @Test
    void testSetLightingScene_MovieMode() {
        StateManager stateManager = new StateManager();
        LightManager lightManager = new LightManager(stateManager);

        lightManager.onStateChange("scene", "movie");

        assertEquals("movie", lightManager.getCurrentScene(), "Lighting scene should be set to 'movie'.");
    }

    @Test
    void testOnStateChange_InvalidKey() {
        StateManager stateManager = new StateManager();
        LightManager lightManager = new LightManager(stateManager);

        lightManager.onStateChange("invalidKey", 50.0);

        assertEquals("default", lightManager.getCurrentScene(), "Invalid key should not change lighting scene.");
    }
}

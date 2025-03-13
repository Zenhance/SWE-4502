package lab11_210042164.test;

import lab11_210042164.implementation.features.LightManager;
import lab11_210042164.implementation.manager.StateManager;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class LightManagerTest {

    private TestStateManager testStateManager;
    private LightManager lightManager;

    // Custom test implementation of StateManager to track calls
    private static class TestStateManager extends StateManager {
        private Map<String, Object> updatedStates = new HashMap<>();

        @Override
        public void updateState(String key, Object value) {
            super.updateState(key, value);
            updatedStates.put(key, value);
        }

        public boolean wasStateUpdated(String key) {
            return updatedStates.containsKey(key);
        }

        public Object getUpdatedValue(String key) {
            return updatedStates.get(key);
        }

        public void clearUpdatedStates() {
            updatedStates.clear();
        }
    }

    @Before
    public void setUp() {
        testStateManager = new TestStateManager();
        lightManager = new LightManager(testStateManager);
    }

    @Test
    public void testAmbientLightLevelChange() {
        // Set ambient light level
        lightManager.onStateChange("ambientLight", 20);

        // Verify level changed
        assertEquals(20, lightManager.getAmbientLightLevel());
    }

    @Test
    public void testRoomOccupancyChange() {
        // Set a room as occupied
        lightManager.onStateChange("roomOccupancy", "LivingRoom");

        // Verify room is marked as occupied
        assertTrue(lightManager.isRoomOccupied("LivingRoom"));

        // Verify state manager was called to update light level
        assertTrue(testStateManager.wasStateUpdated("lightLevel_LivingRoom"));
    }

    @Test
    public void testMultipleRoomOccupancy() {
        // Set first room as occupied
        lightManager.onStateChange("roomOccupancy", "LivingRoom");
        assertTrue(lightManager.isRoomOccupied("LivingRoom"));

        // Set second room as occupied
        lightManager.onStateChange("roomOccupancy", "Bedroom");

        // Verify new room is occupied and old room is now unoccupied
        assertTrue(lightManager.isRoomOccupied("Bedroom"));
        assertFalse(lightManager.isRoomOccupied("LivingRoom"));
    }

    @Test
    public void testLightSceneActivation() {
        // Mark room as occupied first
        lightManager.onStateChange("roomOccupancy", "LivingRoom");

        // Activate a light scene
        lightManager.onStateChange("lightScene", "reading");

        // Verify light level was set according to the scene
        assertEquals(80, lightManager.getRoomLightLevel("LivingRoom"));
    }

    @Test
    public void testAddCustomLightScene() {
        // Create a custom scene
        Map<String, Integer> customScene = new HashMap<>();
        customScene.put("LivingRoom", 60);
        customScene.put("Kitchen", 75);

        // Add the scene
        lightManager.addLightScene("custom", customScene);

        // Mark room as occupied
        lightManager.onStateChange("roomOccupancy", "LivingRoom");

        // Activate the scene
        lightManager.onStateChange("lightScene", "custom");

        // Verify scene was applied
        assertEquals(60, lightManager.getRoomLightLevel("LivingRoom"));
    }

    @Test
    public void testUnoccupiedRoomsDontActivateScene() {
        // Activate a scene without setting room occupancy
        lightManager.onStateChange("lightScene", "reading");

        // Light level should remain at 0 if room is not occupied
        assertEquals(0, lightManager.getRoomLightLevel("LivingRoom"));
    }
}
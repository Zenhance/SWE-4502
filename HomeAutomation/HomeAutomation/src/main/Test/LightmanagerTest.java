// Light Management Component Tests
package main.Test;

import main.Code.components.LightManager;
import core.EventType;
import core.HomeSystem;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class LightManagerTest {

    private LightManager lightManager;
    private HomeSystem homeSystem;

    @Before
    public void setup() {
        // Manual instantiation of HomeSystem and LightManager
        homeSystem = new HomeSystem(); // Assuming this is the constructor
        lightManager = new LightManager(homeSystem) {
            @Override
            public void update(EventType eventType, Map<String, Object> data) {

            }

            @Override
            public void setLightLevel(String room, int level) {

            }

            @Override
            public int getLightLevel(String room) {
                return 0;
            }

            @Override
            public void setScene(String room, String scene) {

            }

            @Override
            public String getCurrentScene(String room) {
                return "";
            }

            @Override
            public void adjustBasedOnOccupancy(String room, boolean occupied) {

            }

            @Override
            public boolean isLightAdjusted(String kitchen, boolean b) {
                return false;
            }
        };
    }

    @Test
    public void testLightLevelControl() {
        // Test setting and getting light levels
        lightManager.setLightLevel("living_room", 75);

        // Manually simulate the behavior of lightManager.setLightLevel
        assertEquals(75, lightManager.getLightLevel("living_room"));
    }

    @Test
    public void testSceneManagement() {
        // Test setting and getting scenes
        lightManager.setScene("bedroom", "reading");

        // Manually simulate the behavior of lightManager.getCurrentScene
        assertEquals("reading", lightManager.getCurrentScene("bedroom"));
    }

    @Test
    public void testOccupancyBasedAdjustment() {
        // Test light adjustment based on occupancy
        lightManager.adjustBasedOnOccupancy("kitchen", true);
        lightManager.adjustBasedOnOccupancy("bathroom", false);

        // Simulate verifying that adjustments are made manually
        // Example, the "adjustBasedOnOccupancy" would internally change some state that you verify.
        assertTrue(lightManager.isLightAdjusted("kitchen", true));
        assertFalse(lightManager.isLightAdjusted("bathroom", false));
    }

    @Test
    public void testLightLevelEventNotification() {
        // Manually set the light level and verify it without mock
        lightManager.setLightLevel("dining_room", 60);

        // Directly check the result
        assertEquals(60, lightManager.getLightLevel("dining_room"));
    }

    @Test
    public void testObserverUpdate() {
        // Manually create motion data that should trigger light adjustment
        Map<String, Object> motionData = new HashMap<>();
        motionData.put("location", "living_room");
        motionData.put("detected", true);

        // Simulate the update (manually trigger light manager logic)
        lightManager.update(EventType.MOTION_DETECTED, motionData);

        // Simulate verifying if the update method responds correctly to the motion detection
        assertTrue(lightManager.isLightAdjusted("living_room", true));
    }
}

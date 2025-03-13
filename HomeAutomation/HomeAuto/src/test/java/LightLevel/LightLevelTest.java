package LightLevel;

import Core.HomeEnvironment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LightLevelTest {

    private LightLevel lightLevel;
    private HomeEnvironment homeEnvironment;

    @BeforeEach
    void setUp() {
        lightLevel = new LightLevel();
        homeEnvironment = HomeEnvironment.getInstance();
        homeEnvironment.registerObserver("lightLevel", lightLevel); // Register observer for "lightLevel"
        homeEnvironment.registerObserver("occupancy", lightLevel);   // Register observer for room occupancy
        homeEnvironment.registerObserver("scene", lightLevel);        // Register observer for scene changes
    }

    @Test
    void testLightTurnOnBasedOnLowLightLevelAndOccupiedRoom() {
        // Simulate low ambient light and room occupancy
        homeEnvironment.setState("lightLevel", 40);  // Light level <= 50
        homeEnvironment.setState("occupancy", true); // Room is occupied

        // Verify that the light is on
        assertTrue(lightLevel.isLightOn(), "Light should be on when the room is occupied and ambient light is low.");
    }

    @Test
    void testLightTurnOffBasedOnHighLightLevel() {
        // Simulate high ambient light and room occupancy
        homeEnvironment.setState("lightLevel", 60);  // Light level > 50
        homeEnvironment.setState("occupancy", true); // Room is occupied

        // Verify that the light is off
        assertFalse(lightLevel.isLightOn(), "Light should be off when the ambient light is high.");
    }

    @Test
    void testLightTurnOffWhenRoomIsUnoccupied() {
        // Simulate a low ambient light and unoccupied room
        homeEnvironment.setState("lightLevel", 40);  // Light level <= 50
        homeEnvironment.setState("occupancy", false); // Room is not occupied

        // Verify that the light is off
        assertFalse(lightLevel.isLightOn(), "Light should be off when the room is not occupied.");
    }

    @Test
    void testSceneReading() {
        // Simulate room occupancy and scene set to "reading"
        homeEnvironment.setState("occupancy", true);  // Room is occupied
        homeEnvironment.setState("scene", "reading"); // Set scene to "reading"

        // Verify that the light is on for reading (as per the behavior defined for the scene)
        assertTrue(lightLevel.isLightOn(), "Light should be on for reading scene.");
    }

    @Test
    void testSceneMovieWatching() {
        // Simulate room occupancy and scene set to "movieWatching"
        homeEnvironment.setState("occupancy", true);  // Room is occupied
        homeEnvironment.setState("scene", "movieWatching"); // Set scene to "movieWatching"

        // Verify that the light is on for movie watching (dim light)
        assertTrue(lightLevel.isLightOn(), "Light should be on for movie watching scene.");
    }

    @Test
    void testDefaultSceneWhenNoSceneSpecified() {
        // Simulate room occupancy with no specific scene
        homeEnvironment.setState("occupancy", true);  // Room is occupied
        homeEnvironment.setState("scene", null);  // No scene provided (default should be used)

        // Verify that the light is on for the default scene
        assertTrue(lightLevel.isLightOn(), "Light should be on for the default scene.");
    }

    @Test
    void testLightTurnOffWhenRoomBecomesUnoccupied() {
        // Simulate the light being on (low ambient light and room occupied)
        homeEnvironment.setState("lightLevel", 40);
        homeEnvironment.setState("occupancy", true); // Room is occupied
        assertTrue(lightLevel.isLightOn(), "Light should be on when room is occupied.");

        // Now simulate room becoming unoccupied
        homeEnvironment.setState("occupancy", false); // Room is unoccupied

        // Verify that the light is turned off
        assertFalse(lightLevel.isLightOn(), "Light should be off when the room becomes unoccupied.");
    }
}

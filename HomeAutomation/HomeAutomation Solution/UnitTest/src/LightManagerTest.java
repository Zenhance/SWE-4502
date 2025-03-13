import LightManager.LightManager;
import CoreFramework.HomeEnvironment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LightManagerTest {
    private LightManager lightManager;
    private HomeEnvironment homeEnvironment;

    @BeforeEach
    void setUp() {
        homeEnvironment = HomeEnvironment.getInstance();
        lightManager = new LightManager();
    }

    @Test
    void testUpdateAmbientLight() {
        homeEnvironment.setState("ambientLight", 40);
        assertEquals(40, lightManager.getAmbientLightLevel(), "Ambient light level should update correctly");
    }

    @Test
    void testUpdateRoomOccupancy() {
        homeEnvironment.setState("roomOccupancy", true);
        assertTrue(lightManager.isRoomOccupied(), "Room occupancy should update correctly");

        homeEnvironment.setState("roomOccupancy", false);
        assertFalse(lightManager.isRoomOccupied(), "Room occupancy should update correctly when set to false");
    }

    @Test
    void testUpdateScene() {
        homeEnvironment.setState("lightScene", "movie");
        assertEquals("movie", lightManager.getCurrentScene(), "Light scene should update correctly");
    }

    @Test
    void testAdjustLighting() {
        homeEnvironment.setState("roomOccupancy", true);
        homeEnvironment.setState("ambientLight", 20);
        homeEnvironment.setState("lightScene", "reading");

        assertEquals("reading", lightManager.getCurrentScene(), "Scene should be 'reading'");
        assertEquals(20, lightManager.getAmbientLightLevel(), "Ambient light level should be 20");
    }

    @Test
    void testLightsOffWhenRoomUnoccupied() {
        homeEnvironment.setState("roomOccupancy", false);
        assertFalse(lightManager.isRoomOccupied(), "Lights should be off when room is unoccupied");
    }
}


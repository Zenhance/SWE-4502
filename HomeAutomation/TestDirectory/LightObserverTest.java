import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LightObserverTest {

    // Test Case 1: Light Adjustment for Multiple Light Events (General Test)
    @Test
    void testMultipleLightEvents() {
        // Create light control system and observer
        LightControlSystem lightSystem = new LightControlSystem();
        LightObserver observer = new LightObserver();

        // Register observer
        lightSystem.registerObserver(observer);

        // Simulate multiple light status changes
        lightSystem.changeLightStatus(25, true, "Living Room");
        lightSystem.changeLightStatus(65, true, "Bedroom");
        lightSystem.changeLightStatus(90, true, "Kitchen");

        // Assert that the observer received the last updated light level, scene, and room
        assertEquals(30, observer.getChangedLightLevel());
        assertEquals("Movie", observer.getScene());
        assertEquals("Kitchen", observer.getLastRoom());
    }

    // Test Case 2: Light Adjustment When Room Occupied and Light Level is Medium
    @Test
    void testLightAdjustmentWhenRoomOccupiedAndLightMedium() {
        // Create light control system and observer
        LightControlSystem lightSystem = new LightControlSystem();
        LightObserver observer = new LightObserver();

        // Register observer
        lightSystem.registerObserver(observer);

        // Simulate light status change with medium light level (50) and room occupied
        lightSystem.changeLightStatus(50, true, "Bedroom");

        // Assert that the observer received the correct adjusted light level and scene
        assertEquals(60, observer.getChangedLightLevel()); // Light level should be adjusted to 60
        assertEquals("Normal", observer.getScene()); // Scene should be "Normal"
        assertEquals("Bedroom", observer.getLastRoom()); // Room should be "Bedroom"
    }

    // Test Case 3: Light Adjustment When Room Unoccupied
    @Test
    void testLightAdjustmentWhenRoomUnoccupied() {
        // Create light control system and observer
        LightControlSystem lightSystem = new LightControlSystem();
        LightObserver observer = new LightObserver();

        // Register observer
        lightSystem.registerObserver(observer);

        // Simulate light status change with medium light level (50) and room unoccupied
        lightSystem.changeLightStatus(50, false, "Living Room");

        // Assert that the observer received the correct adjusted light level and scene
        assertEquals(0, observer.getChangedLightLevel()); // Light level should be turned off
        assertEquals("Off", observer.getScene()); // Scene should be "Off"
        assertEquals("Living Room", observer.getLastRoom()); // Room should be "Living Room"
    }

}

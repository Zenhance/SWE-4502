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
}

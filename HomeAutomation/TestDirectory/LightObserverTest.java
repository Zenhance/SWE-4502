import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LightObserverTest {

    @Test
    void testMultipleLightEvents() {
        // Create light control system and observer
        LightControlSystem lightSystem = new LightControlSystem();
        LightObserver observer = new LightObserver();

        // Register observer
        lightSystem.registerObserver(observer);

        // Simulate multiple light status changes
        lightSystem.changeLightStatus("On", "Living Room");
        lightSystem.changeLightStatus("Off", "Bedroom");
        lightSystem.changeLightStatus("On", "Kitchen");

        // Assert that the observer received the last updated light status and room
        assertEquals("On", observer.getLastLightStatus());
        assertEquals("Kitchen", observer.getLastRoom());
    }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TemperatureObserverTest {

    @Test
    void testMultipleTemperatureEvents() {
        // Create temperature control system and observer
        TemperatureControlSystem tempSystem = new TemperatureControlSystem();
        TemperatureObserver observer = new TemperatureObserver();

        // Register observer
        tempSystem.registerObserver(observer);

        // Simulate multiple temperature changes
        tempSystem.changeTemperature("22°C", "Living Room");
        tempSystem.changeTemperature("18°C", "Bedroom");
        tempSystem.changeTemperature("24°C", "Kitchen");

        // Assert that the observer received the last updated temperature and room
        assertEquals("24°C", observer.getLastTemperature());
        assertEquals("Kitchen", observer.getLastRoom());
    }
}

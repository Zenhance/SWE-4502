import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TemperatureObserverTest {

    // Test Case 1: Heating Activation When Temperature Falls Below Target minus Hysteresis
    @Test
    void testHeatingActivationWhenTemperatureFallsBelowThreshold() {
        // Create temperature control system and observer
        TemperatureControlSystem tempSystem = new TemperatureControlSystem();
        TemperatureObserver observer = new TemperatureObserver();

        // Register observer
        tempSystem.registerObserver(observer);

        // Simulate temperature falling below the target temperature minus hysteresis
        tempSystem.changeTemperature(17, "Living Room");

        // Assert that heating is activated
        assertTrue(observer.isHeating);
        assertFalse(observer.isCooling);
    }

    // Test Case 2: Cooling Activation When Temperature Rises Above Target plus Hysteresis
    @Test
    void testCoolingActivationWhenTemperatureRisesAboveThreshold() {
        // Create temperature control system and observer
        TemperatureControlSystem tempSystem = new TemperatureControlSystem();
        TemperatureObserver observer = new TemperatureObserver();

        // Register observer
        tempSystem.registerObserver(observer);

        // Simulate temperature rising above the target temperature plus hysteresis
        tempSystem.changeTemperature(27, "Bedroom");

        // Assert that cooling is activated
        assertFalse(observer.isHeating);
        assertTrue(observer.isCooling);
    }

}

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

    // Test Case 3: Heating Deactivation When Temperature Falls Within Range
    @Test
    void testHeatingDeactivationWhenTemperatureFallsWithinRange() {
        // Create temperature control system and observer
        TemperatureControlSystem tempSystem = new TemperatureControlSystem();
        TemperatureObserver observer = new TemperatureObserver();

        // Register observer
        tempSystem.registerObserver(observer);

        // Simulate temperature falling to 20°C, within range for deactivation of heating
        tempSystem.changeTemperature(20, "Living Room");

        // Assert that neither heating nor cooling is activated
        assertFalse(observer.isHeating);
        assertFalse(observer.isCooling);
    }

    // Test Case 4: Cooling Deactivation When Temperature Rises Within Range
    @Test
    void testCoolingDeactivationWhenTemperatureRisesWithinRange() {
        // Create temperature control system and observer
        TemperatureControlSystem tempSystem = new TemperatureControlSystem();
        TemperatureObserver observer = new TemperatureObserver();

        // Register observer
        tempSystem.registerObserver(observer);

        // Simulate temperature rising to 24°C, within range for deactivation of cooling
        tempSystem.changeTemperature(24, "Bedroom");

        // Assert that neither heating nor cooling is activated
        assertFalse(observer.isHeating);
        assertFalse(observer.isCooling);
    }

}


import org.junit.Test;
import static org.junit.Assert.*;

public class TemperatureControllerTest {

    @Test
    public void testHeatingOn() {
        // Create an instance of TemperatureController
        TemperatureController controller = new TemperatureController();

        // Simulate the environment state by directly passing the temperature
        controller.update("Temperature", 18.0); // Simulate temperature below target

        // Check that the heating is turned on and cooling is off
        assertTrue(controller.isHeatingOn());
        assertFalse(controller.isCoolingOn());
    }

    @Test
    public void testCoolingOn() {
        // Create an instance of TemperatureController
        TemperatureController controller = new TemperatureController();

        // Simulate the environment state with a temperature above the target
        controller.update("Temperature", 25.0); // Simulate temperature above target

        // Check that cooling is turned on and heating is off
        assertFalse(controller.isHeatingOn());
        assertTrue(controller.isCoolingOn());
    }

    @Test
    public void testNoAction() {
        // Create an instance of TemperatureController
        TemperatureController controller = new TemperatureController();

        // Simulate the environment state with the target temperature
        controller.update("Temperature", 22.0); // Simulate temperature equal to target

        // Check that neither heating nor cooling is turned on
        assertFalse(controller.isHeatingOn());
        assertFalse(controller.isCoolingOn());
    }
}
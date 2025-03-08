import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TemperatureControllerTest {
    private TemperatureController controller;
    private SystemState state;

    @BeforeEach
    public void setup() {
        controller = new TemperatureController();
        state = new SystemState();
        controller.setTargetTemperature(22);
    }

    @Test
    public void testHeatingActivationWhenTemperatureFallsBelowThreshold() {
        state.temperature = 17;
        controller.update(state);

        assertTrue(controller.isHeating);
        assertFalse(controller.isCooling);
    }

    @Test
    public void testCoolingActivationWhenTemperatureRisesAboveThreshold() {
        state.temperature = 27;
        controller.update(state);

        assertFalse(controller.isHeating);
        assertTrue(controller.isCooling);
    }

    @Test
    public void testHVACSystemIdleWhenTemperatureIsWithinHysteresisRange() {
        state.temperature = 22;
        controller.update(state);

        assertFalse(controller.isHeating);
        assertFalse(controller.isCooling);
    }

    @Test
    public void testHeatingDeactivationWhenTemperatureFallsWithinRange() {
        state.temperature = 20;
        controller.update(state);

        assertFalse(controller.isHeating);
        assertFalse(controller.isCooling);
    }

    @Test
    public void testCoolingDeactivationWhenTemperatureRisesWithinRange() {
        state.temperature = 24;
        controller.update(state);

        assertFalse(controller.isHeating);
        assertFalse(controller.isCooling);
    }
}

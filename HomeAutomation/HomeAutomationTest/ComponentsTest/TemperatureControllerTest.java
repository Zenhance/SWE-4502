package ComponentsTest;

import static org.junit.jupiter.api.Assertions.*;

import Components.TemperatureController;
import Core_Models.SystemState;
import Core_Models.SystemStateManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TemperatureControllerTest {
    private TemperatureController controller;
    private SystemState state;
    public SystemStateManager sysState;

    @BeforeEach
    public void setup() {
        controller = new TemperatureController();
        state = new SystemState();
        controller.setTargetTemperature(22);
        sysState = new SystemStateManager();
        sysState.registerObserver(controller);
    }

    @Test
    public void testHeatingActivationWhenTemperatureFallsBelowThreshold() {
        state.temperature = 17;
        sysState.setState(state);

        assertTrue(controller.isHeating);
        assertFalse(controller.isCooling);
    }

    @Test
    public void testCoolingActivationWhenTemperatureRisesAboveThreshold() {
        state.temperature = 27;
        sysState.setState(state);

        assertFalse(controller.isHeating);
        assertTrue(controller.isCooling);
    }

    @Test
    public void testHVACSystemIdleWhenTemperatureIsWithinHysteresisRange() {
        state.temperature = 22;
        sysState.setState(state);

        assertFalse(controller.isHeating);
        assertFalse(controller.isCooling);
    }

    @Test
    public void testHeatingDeactivationWhenTemperatureFallsWithinRange() {
        state.temperature = 20;
        sysState.setState(state);

        assertFalse(controller.isHeating);
        assertFalse(controller.isCooling);
    }

    @Test
    public void testCoolingDeactivationWhenTemperatureRisesWithinRange() {
        state.temperature = 24;
        sysState.setState(state);

        assertFalse(controller.isHeating);
        assertFalse(controller.isCooling);
    }
}

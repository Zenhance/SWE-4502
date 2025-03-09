package Lab_11_210042166.Issue_4.Unit_Test;
import Lab_11_210042166.Issue_4.TemperatureControl.TemperatureControl;
import Lab_11_210042166.Project_Structure.Storage_Class.EnvironmentState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class TemperatureControlTest {
    private TemperatureControl temperatureControl;
    private EnvironmentState state;

    @BeforeEach
    void setUp() {
        temperatureControl = new TemperatureControl(22.0, 1.0);
        state = new EnvironmentState(0.0, false, 0);
    }
    @Test
    void testHeatingActivationWhenTemperatureTooLow() {
        state.setTemperature(19.0);
        temperatureControl.update(state);
        assertTrue(temperatureControl.isHeating(), "Heating should be activated when temperature is too low.");
        assertFalse(temperatureControl.isCooling(), "Cooling should not be activated.");
    }
    @Test
    void testCoolingActivationWhenTemperatureTooHigh() {
        state.setTemperature(25.0);
        temperatureControl.update(state);
        assertTrue(temperatureControl.isCooling(), "Cooling should be activated when temperature is too high.");
        assertFalse(temperatureControl.isHeating(), "Heating should not be activated.");
    }
    @Test
    void testHVACDeactivationWhenTemperatureWithinRange() {
        state.setTemperature(22.0);
        temperatureControl.update(state);
        assertFalse(temperatureControl.isHeating(), "Heating should not be active.");
        assertFalse(temperatureControl.isCooling(), "Cooling should not be active.");
    }
    @Test
    void testHeatingDoesNotActivateWithinHysteresisRange() {
        state.setTemperature(21.0);
        temperatureControl.update(state);
        assertFalse(temperatureControl.isHeating(), "Heating should not activate within hysteresis range.");
    }
    @Test
    void testCoolingDoesNotActivateWithinHysteresisRange() {
        state.setTemperature(23.0);
        temperatureControl.update(state);
        assertFalse(temperatureControl.isCooling(), "Cooling should not activate within hysteresis range.");
    }




}

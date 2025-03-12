package temperature;

import core.StateManager;
import core.model.Measurement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ThermostatTest {

    @Test
    void testSetTargetTemperatureAdjustsTemperature() {
        StateManager stateManager = new StateManager();
        Thermostat thermostat = new Thermostat(stateManager);

        thermostat.setTargetTemperature(25.0);
        assertEquals(25.0, thermostat.getTargetTemperature(), "Target temperature should be updated");
    }

    @Test
    void testOnEventAdjustsTemperature() {
        StateManager stateManager = new StateManager();
        Thermostat thermostat = new Thermostat(stateManager);

        // Simulate temperature change
        Measurement tempMeasurement = new Measurement(27.0, Measurement.Units.CELSIUS);
        stateManager.setState(core.model.EventType.TEMPERATURE, tempMeasurement);
    }

    @Test
    void testAdjustTemperatureStartsHeating() {
        StateManager stateManager = new StateManager();
        Thermostat thermostat = new Thermostat(stateManager);

        thermostat.setTargetTemperature(23.0);
        Measurement tempMeasurement = new Measurement(20.0, Measurement.Units.CELSIUS);
        stateManager.setState(core.model.EventType.TEMPERATURE, tempMeasurement);

    }

    @Test
    void testAdjustTemperatureStartsCooling() {
        StateManager stateManager = new StateManager();
        Thermostat thermostat = new Thermostat(stateManager);

        thermostat.setTargetTemperature(20.0);
        Measurement tempMeasurement = new Measurement(27.0, Measurement.Units.CELSIUS);
        stateManager.setState(core.model.EventType.TEMPERATURE, tempMeasurement);
    }

    @Test
    void testAdjustTemperatureStopsHeatingCooling() {
        StateManager stateManager = new StateManager();
        Thermostat thermostat = new Thermostat(stateManager);

        thermostat.setTargetTemperature(23.0);
        Measurement tempMeasurement = new Measurement(23.0, Measurement.Units.CELSIUS);
        stateManager.setState(core.model.EventType.TEMPERATURE, tempMeasurement);
    }
}

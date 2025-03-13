package Temperature;

import Core.HomeEnvironment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureControllerTest {
    private TemperatureController temperatureController;
    private HomeEnvironment homeEnvironment;

    @BeforeEach
    void setUp() {
        temperatureController = new TemperatureController();
        homeEnvironment = HomeEnvironment.getInstance();
        homeEnvironment.registerObserver("temperature", temperatureController); // Register observer for temperature changes
    }

    @Test
    void testHeaterActivation() {
        // Simulate a temperature below the target heating temperature - hysteresis buffer (16°C)
        homeEnvironment.setState("temperature", 16); // Below target heating temperature (18°C) - buffer of 2°C

        // Verify that the heater is on and cooler is off
        assertTrue(temperatureController.isHeaterOn(), "Heater should be on when temperature is below 16°C.");
        assertFalse(temperatureController.isCoolerOn(), "Cooler should be off when heater is on.");
    }

    @Test
    void testCoolerActivation() {
        // Simulate a temperature above the target cooling temperature + hysteresis buffer (27°C)
        homeEnvironment.setState("temperature", 27); // Above target cooling temperature (25°C) + buffer of 2°C

        // Verify that the cooler is on and heater is off
        assertTrue(temperatureController.isCoolerOn(), "Cooler should be on when temperature is above 27°C.");
        assertFalse(temperatureController.isHeaterOn(), "Heater should be off when cooler is on.");
    }

    @Test
    void testHeaterAndCoolerDeactivationInComfortableRange() {
        // Simulate a temperature within the comfortable range (22°C)
        homeEnvironment.setState("temperature", 22); // Between 18°C and 25°C (with hysteresis buffer of 2°C)

        // Verify that both the heater and cooler are off
        assertFalse(temperatureController.isHeaterOn(), "Heater should be off when temperature is within the comfortable range.");
        assertFalse(temperatureController.isCoolerOn(), "Cooler should be off when temperature is within the comfortable range.");
    }

    @Test
    void testHysteresis() {
        // Simulate a temperature change that is close to the threshold and should not immediately change the state
        homeEnvironment.setState("temperature", 17); // Just above 16°C (after the heater is turned on)

        // Check if the heater remains on and the cooler is off (because of the hysteresis buffer)
        assertTrue(temperatureController.isHeaterOn(), "Heater should remain on within the hysteresis range.");
        assertFalse(temperatureController.isCoolerOn(), "Cooler should remain off within the hysteresis range.");

        // Simulate a temperature change that would turn off the heater
        homeEnvironment.setState("temperature", 23); // Within the comfortable range (neither heating nor cooling)

        // Ensure that both the heater and cooler are turned off
        assertFalse(temperatureController.isHeaterOn(), "Heater should be off when temperature is within the comfortable range.");
        assertFalse(temperatureController.isCoolerOn(), "Cooler should be off when temperature is within the comfortable range.");
    }

    @Test
    void testNoSimultaneousHeatingAndCooling() {
        // Simulate a temperature below the heating threshold (16°C)
        homeEnvironment.setState("temperature", 16); // Below the heating threshold

        // Verify that the heater is on and cooler is off
        assertTrue(temperatureController.isHeaterOn(), "Heater should be on.");
        assertFalse(temperatureController.isCoolerOn(), "Cooler should be off.");

        // Simulate a temperature above the cooling threshold (27°C)
        homeEnvironment.setState("temperature", 27); // Above the cooling threshold

        // Verify that the heater is turned off and the cooler is turned on
        assertFalse(temperatureController.isHeaterOn(), "Heater should be off.");
        assertTrue(temperatureController.isCoolerOn(), "Cooler should be on.");
    }
}

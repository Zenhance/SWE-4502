package lab11_210042164.test;


import lab11_210042164.implementation.features.TemperatureController;
import lab11_210042164.implementation.manager.StateManager;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class TemperatureControllerTest {

    private TestStateManager testStateManager;
    private TemperatureController temperatureController;

    private static class TestStateManager extends StateManager {
        private Map<String, Object> updatedStates = new HashMap<>();

        @Override
        public void updateState(String key, Object value) {
            super.updateState(key, value);
            updatedStates.put(key, value);
        }

        public boolean wasStateUpdated(String key) {
            return updatedStates.containsKey(key);
        }

        public Object getUpdatedValue(String key) {
            return updatedStates.get(key);
        }

        public void clearUpdatedStates() {
            updatedStates.clear();
        }
    }

    @Before
    public void setUp() {
        testStateManager = new TestStateManager();
        temperatureController = new TemperatureController(testStateManager);
    }

    @Test
    public void testInitialState() {

        assertEquals(22.0, temperatureController.getCurrentTemperature(), 0.01);
        assertEquals(22.0, temperatureController.getTargetTemperature(), 0.01);
        assertEquals(0.5, temperatureController.getHysteresis(), 0.01);
        assertFalse(temperatureController.isHeatingOn());
        assertFalse(temperatureController.isCoolingOn());
    }

    @Test
    public void testHeatingActivation() {
        // Set target temperature
        temperatureController.onStateChange("targetTemperature", 23.0);

        // Set current temperature below target (beyond hysteresis)
        temperatureController.onStateChange("currentTemperature", 22.0);
        assertFalse(temperatureController.isHeatingOn());

        temperatureController.onStateChange("currentTemperature", 22.4);
        assertFalse(temperatureController.isHeatingOn());

        // This should trigger heating
        temperatureController.onStateChange("currentTemperature", 22.2);
        assertTrue(temperatureController.isHeatingOn());
        assertFalse(temperatureController.isCoolingOn());

        // Verify state manager was called to update heating status
        assertTrue(testStateManager.wasStateUpdated("heatingStatus"));
        assertTrue((Boolean)testStateManager.getUpdatedValue("heatingStatus"));
        assertTrue(testStateManager.wasStateUpdated("coolingStatus"));
        assertFalse((Boolean)testStateManager.getUpdatedValue("coolingStatus"));
    }

    @Test
    public void testCoolingActivation() {
        // Set target temperature
        temperatureController.onStateChange("targetTemperature", 22.0);

        // Set current temperature above target (beyond hysteresis)
        temperatureController.onStateChange("currentTemperature", 22.8);
        assertTrue(temperatureController.isCoolingOn());
        assertFalse(temperatureController.isHeatingOn());


        assertTrue(testStateManager.wasStateUpdated("coolingStatus"));
        assertTrue((Boolean)testStateManager.getUpdatedValue("coolingStatus"));
        assertTrue(testStateManager.wasStateUpdated("heatingStatus"));
        assertFalse((Boolean)testStateManager.getUpdatedValue("heatingStatus"));
    }

    @Test
    public void testHysteresis() {

        temperatureController.onStateChange("targetTemperature", 22.0);


        temperatureController.onStateChange("currentTemperature", 21.0);
        assertTrue(temperatureController.isHeatingOn());

        // Raise temperature to within hysteresis range
        temperatureController.onStateChange("currentTemperature", 21.6);
        assertTrue(temperatureController.isHeatingOn()); // Still on due to hysteresis

        // Raise temperature to target
        temperatureController.onStateChange("currentTemperature", 22.0);
        assertFalse(temperatureController.isHeatingOn()); // Should turn off at target
    }

    @Test
    public void testChangingHysteresis() {

        temperatureController.setHysteresis(1.0);
        assertEquals(1.0, temperatureController.getHysteresis(), 0.01);

        temperatureController.onStateChange("targetTemperature", 22.0);


        temperatureController.onStateChange("currentTemperature", 21.5);
        assertFalse(temperatureController.isHeatingOn());

        temperatureController.onStateChange("currentTemperature", 20.9);
        assertTrue(temperatureController.isHeatingOn());
    }
}
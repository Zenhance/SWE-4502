package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import smarthome.core.*;
import smarthome.components.*;

public class TemperatureControlSystemTest {

    @Mock
    private HomeSystem mockHomeSystem;

    private TemperatureControlSystem tempSystem;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        tempSystem = new TemperatureControlSystem(mockHomeSystem);

        // Verify observer registrations
        Mockito.verify(mockHomeSystem).registerObserver("temperature", tempSystem);
        Mockito.verify(mockHomeSystem).registerObserver("targetTemperature", tempSystem);
    }

    @Test
    public void testInitialState() {
        assertEquals(22.0, tempSystem.getTargetTemperature(), 0.01);
        assertFalse(tempSystem.isHeatingOn());
        assertFalse(tempSystem.isCoolingOn());
    }

    @Test
    public void testHeatingActivation() {
        // Trigger a temperature that's below target with hysteresis
        tempSystem.onStateChange("temperature", 22.0, 20.0);

        // Heating should turn on
        assertTrue(tempSystem.isHeatingOn());
        assertFalse(tempSystem.isCoolingOn());
    }

    @Test
    public void testCoolingActivation() {
        // Trigger a temperature that's above target with hysteresis
        tempSystem.onStateChange("temperature", 22.0, 24.0);

        // Cooling should turn on
        assertFalse(tempSystem.isHeatingOn());
        assertTrue(tempSystem.isCoolingOn());
    }

    @Test
    public void testHeatingDeactivation() {
        // Set up initial state - heating is on
        tempSystem.onStateChange("temperature", 22.0, 20.0);
        assertTrue(tempSystem.isHeatingOn());

        // Raise temperature enough to turn off heating
        tempSystem.onStateChange("temperature", 20.0, 23.0);
        assertFalse(tempSystem.isHeatingOn(), "Heating should turn off when temperature exceeds target");
    }

    @Test
    public void testCoolingDeactivation() {
        // Set up initial state - cooling is on
        tempSystem.onStateChange("temperature", 22.0, 25.0);
        assertTrue(tempSystem.isCoolingOn());

        // Lower temperature enough to turn off cooling
        tempSystem.onStateChange("temperature", 25.0, 21.0);
        assertFalse(tempSystem.isCoolingOn(), "Cooling should turn off when temperature drops below target");
    }

    @Test
    public void testHeatingHysteresis() {
        // Set up initial state - heating is on
        tempSystem.onStateChange("temperature", 22.0, 20.0);
        assertTrue(tempSystem.isHeatingOn());

        // Raise temperature but not enough to turn off heating (within hysteresis)
        tempSystem.onStateChange("temperature", 20.0, 21.5);
        assertTrue(tempSystem.isHeatingOn(), "Heating should remain on within hysteresis range");
    }

    @Test
    public void testCoolingHysteresis() {
        // Set up initial state - cooling is on
        tempSystem.onStateChange("temperature", 22.0, 24.0);
        assertTrue(tempSystem.isCoolingOn());

        // Lower temperature but not enough to turn off cooling (within hysteresis)
        tempSystem.onStateChange("temperature", 24.0, 22.5);
        assertTrue(tempSystem.isCoolingOn(), "Cooling should remain on within hysteresis range");
    }

    @Test
    public void testTargetTemperatureChange() {
        // Set up initial state
        Mockito.when(mockHomeSystem.getStateValue("temperature")).thenReturn(22.0);

        // Change target temperature to higher value
        tempSystem.onStateChange("targetTemperature", 22.0, 25.0);
        assertEquals(25.0, tempSystem.getTargetTemperature(), 0.01);
    }

    @Test
    public void testTargetTemperatureTriggersHVACCheck() {
        // Set current temperature to be cold
        Mockito.when(mockHomeSystem.getStateValue("temperature")).thenReturn(18.0);

        // Change target temperature but still above current temp
        tempSystem.onStateChange("targetTemperature", 22.0, 20.0);

        // Heating should be on since current temp (18) is below target (20)
        assertTrue(tempSystem.isHeatingOn());
        assertFalse(tempSystem.isCoolingOn());
    }

    @Test
    public void testIgnoresNonDoubleTemperatureValues() {
        // This should not adjust the HVAC system
        tempSystem.onStateChange("temperature", null, "warm");

        // System state should be unchanged
        assertFalse(tempSystem.isHeatingOn());
        assertFalse(tempSystem.isCoolingOn());
    }
}
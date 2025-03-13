package com.homeautomation.components;

import com.homeautomation.core.EnvironmentalState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TemperatureControlTest {
    private TemperatureControl temperatureControl;
    private EnvironmentalState state;

    @BeforeEach
    void setUp() {
        temperatureControl = new TemperatureControl(22.0); // Target temperature is 22°C
        state = new EnvironmentalState();
    }

    @Test
    void testHeatingTurnsOnWhenTooCold() {
        state.setTemperature((int) 20.0); // Below target
        temperatureControl.updateState(state);
        assertTrue(temperatureControl.isHeatingOn());
        assertFalse(temperatureControl.isCoolingOn());
    }

    @Test
    void testCoolingTurnsOnWhenTooHot() {
        state.setTemperature((int) 24.0); // Above target
        temperatureControl.updateState(state);
        assertTrue(temperatureControl.isCoolingOn());
        assertFalse(temperatureControl.isHeatingOn());
    }

    @Test
    void testNoHeatingOrCoolingWithinRange() {
        state.setTemperature((int) 22.0); // Exactly at target
        temperatureControl.updateState(state);
        assertFalse(temperatureControl.isHeatingOn());
        assertFalse(temperatureControl.isCoolingOn());
    }
}

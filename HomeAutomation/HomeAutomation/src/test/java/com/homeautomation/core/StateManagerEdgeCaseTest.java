package com.homeautomation.core;

import com.homeautomation.components.LightManager;
import com.homeautomation.components.TemperatureControl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StateManagerEdgeCaseTest {
    private StateManager stateManager;
    private LightManager lightManager;
    private TemperatureControl temperatureControl;

    @BeforeEach
    public void setUp() {
        stateManager = new StateManager();
        lightManager = new LightManager();
        temperatureControl = new TemperatureControl(22.5); // or any default temperature


        stateManager.registerComponent(lightManager);
        stateManager.registerComponent(temperatureControl);
    }

    @Test
    public void testNullStateUpdate() {
        assertThrows(NullPointerException.class, () -> stateManager.updateState(null));
    }

    @Test
    public void testExtremeValues() {
        EnvironmentalState state = new EnvironmentalState();
        state.setLightLevel(Integer.MAX_VALUE);
        state.setTemperature(Integer.MIN_VALUE);

        stateManager.updateState(state);

        assertEquals(Integer.MAX_VALUE, lightManager.getCurrentLightLevel());
        assertEquals(Integer.MIN_VALUE, temperatureControl.getCurrentTemperature());
    }
}

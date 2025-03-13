package com.homeautomation.core;

import com.homeautomation.core.*;
import com.homeautomation.components.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class StateManagerTest {
    private StateManager stateManager;
    private LightManager lightManager;
    private TemperatureControl temperatureControl;

    @BeforeEach
    public void setUp() {
        stateManager = new StateManager();

        // Create mock instances of the components
        lightManager = mock(LightManager.class);
        temperatureControl = mock(TemperatureControl.class);

        // Register the mocked components with the StateManager
        stateManager.registerComponent(lightManager);
        stateManager.registerComponent(temperatureControl);
    }

    @Test
    public void testRegisterAndNotifyComponents() {
        // Create an environmental state with some values
        EnvironmentalState state = new EnvironmentalState();
        state.setLightLevel(50);
        state.setTemperature(22);

        // Update the state in the state manager
        stateManager.updateState(state);

        // Verify if the updateState method was called on both components
        verify(lightManager).updateState(state);
        verify(temperatureControl).updateState(state);
    }

    @Test
    public void testUnregisterComponent() {
        // Create an environmental state with some values
        EnvironmentalState state = new EnvironmentalState();
        state.setLightLevel(50);
        state.setTemperature(22);

        // Unregister lightManager before the state update
        stateManager.unregisterComponent(lightManager);

        // Update the state
        stateManager.updateState(state);

        // Verify that lightManager did not receive the state update after being unregistered
        verify(lightManager, times(0)).updateState(state);  // Should not be called
        verify(temperatureControl).updateState(state);      // temperatureControl should still be notified
    }
}

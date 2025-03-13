package com.homeautomation.components;

import com.homeautomation.core.Component;
import com.homeautomation.core.EnvironmentalState;

public class LightManager implements Component {
    @Override
    public void updateState(EnvironmentalState state) {
        // Logic to update the light manager based on the state
        System.out.println("Light Manager updated with light level: " + state.getLightLevel());
    }
}

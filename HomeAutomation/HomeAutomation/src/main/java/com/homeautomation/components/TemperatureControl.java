package com.homeautomation.components;

import com.homeautomation.core.Component;
import com.homeautomation.core.EnvironmentalState;

public class TemperatureControl implements Component {
    @Override
    public void updateState(EnvironmentalState state) {
        // Logic to update the temperature control based on the state
        System.out.println("Temperature Control updated with temperature: " + state.getTemperature());
    }
}

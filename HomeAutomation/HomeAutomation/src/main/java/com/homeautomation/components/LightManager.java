package com.homeautomation.components;

import com.homeautomation.core.Component;
import com.homeautomation.core.EnvironmentalState;

public class LightManager implements Component {
    private boolean lightsOn;
    private int currentLightLevel;  // Add this field to store light level

    @Override
    public void updateState(EnvironmentalState state) {
        // Simple logic: Turn lights on if it's dark and someone is present
        currentLightLevel = state.getLightLevel();  // Update the current light level
        if (currentLightLevel < 30 && state.isRoomOccupied()) {
            lightsOn = true;
        } else {
            lightsOn = false;
        }
    }

    public boolean isLightsOn() {
        return lightsOn;
    }

    // Add this method to retrieve the current light level
    public int getCurrentLightLevel() {
        return currentLightLevel;
    }
}

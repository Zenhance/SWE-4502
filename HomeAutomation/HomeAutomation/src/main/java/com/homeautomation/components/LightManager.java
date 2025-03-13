package com.homeautomation.components;

import com.homeautomation.core.Component;
import com.homeautomation.core.EnvironmentalState;

public class LightManager implements Component {
    private boolean lightsOn;

    @Override
    public void updateState(EnvironmentalState state) {
        // Simple logic: Turn lights on if it's dark and someone is present
        if (state.getLightLevel() < 30 && state.isRoomOccupied()) {
            lightsOn = true;
        } else {
            lightsOn = false;
        }
    }

    public boolean isLightsOn() {
        return lightsOn;
    }
}

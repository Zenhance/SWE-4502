package com.homeautomation.components;

import com.homeautomation.core.Component;
import com.homeautomation.core.EnvironmentalState;

public class MotionDetector implements Component {
    private boolean motionDetected;
    private String lastDetectedLocation;

    public MotionDetector() {
        this.motionDetected = false;
        this.lastDetectedLocation = "None";
    }

    @Override
    public void updateState(EnvironmentalState state) {
        this.motionDetected = state.isMotionDetected();
        this.lastDetectedLocation = state.getMotionLocation();
    }

    public boolean isMotionDetected() {
        return motionDetected;
    }

    public String getLastDetectedLocation() {
        return lastDetectedLocation;
    }
}

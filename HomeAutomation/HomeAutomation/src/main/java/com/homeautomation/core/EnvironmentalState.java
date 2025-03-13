package com.homeautomation.core;

public class EnvironmentalState {
    private int lightLevel;
    private int temperature;
    private boolean roomOccupied;
    private boolean motionDetected;  // ✅ Added for motion detection
    private String motionLocation;   // ✅ Added for motion tracking

    // Getters and Setters
    public int getLightLevel() {
        return lightLevel;
    }

    public void setLightLevel(int lightLevel) {
        this.lightLevel = lightLevel;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public boolean isRoomOccupied() {
        return roomOccupied;
    }

    public void setRoomOccupied(boolean roomOccupied) {
        this.roomOccupied = roomOccupied;
    }

    public boolean isMotionDetected() {  // ✅ Added getter
        return motionDetected;
    }

    public void setMotionDetected(boolean motionDetected) {  // ✅ Added setter
        this.motionDetected = motionDetected;
    }

    public String getMotionLocation() {  // ✅ Added getter
        return motionLocation;
    }

    public void setMotionLocation(String motionLocation) {  // ✅ Added setter
        this.motionLocation = motionLocation;
    }
}

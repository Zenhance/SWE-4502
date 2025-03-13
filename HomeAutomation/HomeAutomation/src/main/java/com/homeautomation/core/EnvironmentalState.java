package com.homeautomation.core;

public class EnvironmentalState {
    private int lightLevel;
    private int temperature;
    private boolean roomOccupied; // Add this property

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

    public boolean isRoomOccupied() { // Getter for room occupancy
        return roomOccupied;
    }

    public void setRoomOccupied(boolean roomOccupied) { // Setter for room occupancy
        this.roomOccupied = roomOccupied;
    }
}

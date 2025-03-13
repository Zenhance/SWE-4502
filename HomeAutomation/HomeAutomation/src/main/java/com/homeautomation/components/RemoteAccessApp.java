package com.homeautomation.components;

import com.homeautomation.core.Component;
import com.homeautomation.core.EnvironmentalState;

import java.util.ArrayList;
import java.util.List;

public class RemoteAccessApp implements Component {
    private EnvironmentalState currentState;
    private final List<String> notifications = new ArrayList<>();

    @Override
    public void updateState(EnvironmentalState state) {
        this.currentState = state;
        notifications.add("State updated: Light Level = " + state.getLightLevel() +
                ", Temperature = " + state.getTemperature() +
                ", Room Occupied = " + state.isRoomOccupied());
    }

    public List<String> getNotifications() {
        return new ArrayList<>(notifications);
    }

    public String getRealTimeStatus() {
        if (currentState == null) {
            return "No data available.";
        }
        return "Current State - Light Level: " + currentState.getLightLevel() +
                ", Temperature: " + currentState.getTemperature() +
                ", Room Occupied: " + currentState.isRoomOccupied();
    }
}

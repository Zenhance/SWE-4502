package com.homeautomation.components;

import com.homeautomation.core.EnvironmentalState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RemoteAccessAppTest {
    private RemoteAccessApp remoteAccessApp;
    private EnvironmentalState state;

    @BeforeEach
    public void setUp() {
        remoteAccessApp = new RemoteAccessApp();
        state = new EnvironmentalState();
        state.setLightLevel(75);
        state.setTemperature(24);
        state.setRoomOccupied(true);
    }

    @Test
    public void testReceiveNotifications() {
        remoteAccessApp.updateState(state);
        List<String> notifications = remoteAccessApp.getNotifications();

        assertFalse(notifications.isEmpty());
        assertEquals("State updated: Light Level = 75, Temperature = 24, Room Occupied = true", notifications.get(0));
    }

    @Test
    public void testRealTimeStatus() {
        remoteAccessApp.updateState(state);
        String status = remoteAccessApp.getRealTimeStatus();

        assertEquals("Current State - Light Level: 75, Temperature: 24, Room Occupied: true", status);
    }

    @Test
    public void testRealTimeStatusWhenNoData() {
        assertEquals("No data available.", remoteAccessApp.getRealTimeStatus());
    }
}

package com.homeautomation.components;

import com.homeautomation.core.EnvironmentalState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LightManagerTest {
    private LightManager lightManager;

    @BeforeEach
    public void setUp() {
        lightManager = new LightManager();
    }

    @Test
    public void testLightsTurnOnInDarkRoomWithOccupancy() {
        EnvironmentalState state = new EnvironmentalState();
        state.setLightLevel(20); // Dark room
        state.setRoomOccupied(true); // Someone is in the room

        lightManager.updateState(state);

        assertTrue(lightManager.isLightsOn(), "Lights should turn ON in a dark occupied room");
    }

    @Test
    public void testLightsStayOffInBrightRoom() {
        EnvironmentalState state = new EnvironmentalState();
        state.setLightLevel(60); // Bright room
        state.setRoomOccupied(true); // Someone is in the room

        lightManager.updateState(state);

        assertFalse(lightManager.isLightsOn(), "Lights should stay OFF in a bright room");
    }

    @Test
    public void testLightsTurnOffWhenRoomIsEmpty() {
        EnvironmentalState state = new EnvironmentalState();
        state.setLightLevel(10); // Dark room
        state.setRoomOccupied(false); // Room is empty

        lightManager.updateState(state);

        assertFalse(lightManager.isLightsOn(), "Lights should stay OFF if the room is empty");
    }
}

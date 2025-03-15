package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import smarthome.core.*;
import smarthome.components.*;
import java.lang.reflect.Field;
import java.util.Map;

public class LightManagementSystemTest {

    @Mock
    private HomeSystem mockHomeSystem;

    private LightManagementSystem lightSystem;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        lightSystem = new LightManagementSystem(mockHomeSystem);

        // Verify observer registrations
        Mockito.verify(mockHomeSystem).registerObserver("motion", lightSystem);
        Mockito.verify(mockHomeSystem).registerObserver("ambientLight", lightSystem);
        Mockito.verify(mockHomeSystem).registerObserver("lightScene", lightSystem);
    }

    @Test
    public void testAdjustLightsForOccupancy() {
        // Set up ambient light to be low
        Mockito.when(mockHomeSystem.getStateValue("ambientLight")).thenReturn(30);

        // Call the method directly
        lightSystem.adjustLightsForOccupancy("livingRoom", true);

        // Access the internal state of room light levels
        try {
            Field roomLightLevelsField = LightManagementSystem.class.getDeclaredField("roomLightLevels");
            roomLightLevelsField.setAccessible(true);
            Map<String, Integer> roomLightLevels = (Map<String, Integer>) roomLightLevelsField.get(lightSystem);

            // Verify the light level was set as expected
            assertEquals(70, roomLightLevels.get("livingRoom").intValue());
        } catch (Exception e) {
            fail("Failed to access room light levels: " + e.getMessage());
        }
    }

    @Test
    public void testAdjustLightsForOccupancyWhenUnoccupied() {
        // Call the method directly with occupied=false
        lightSystem.adjustLightsForOccupancy("livingRoom", false);

        // Access the internal state of room light levels
        try {
            Field roomLightLevelsField = LightManagementSystem.class.getDeclaredField("roomLightLevels");
            roomLightLevelsField.setAccessible(true);
            Map<String, Integer> roomLightLevels = (Map<String, Integer>) roomLightLevelsField.get(lightSystem);

            // Verify lights are turned off
            assertEquals(0, roomLightLevels.get("livingRoom").intValue());
        } catch (Exception e) {
            fail("Failed to access room light levels: " + e.getMessage());
        }
    }

    @Test
    public void testAdjustLightsForAmbientLevel() {
        // Set up room and occupancy
        Mockito.when(mockHomeSystem.getStateValue("currentRoom")).thenReturn("livingRoom");
        Mockito.when(mockHomeSystem.getStateValue("motion")).thenReturn(true);

        // Call the method
        lightSystem.adjustLightsForAmbientLevel(30);

        // Access the internal state of room light levels
        try {
            Field roomLightLevelsField = LightManagementSystem.class.getDeclaredField("roomLightLevels");
            roomLightLevelsField.setAccessible(true);
            Map<String, Integer> roomLightLevels = (Map<String, Integer>) roomLightLevelsField.get(lightSystem);

            // Verify the light level calculation (100 - ambientLight)
            assertEquals(70, roomLightLevels.get("livingRoom").intValue());
        } catch (Exception e) {
            fail("Failed to access room light levels: " + e.getMessage());
        }
    }

    @Test
    public void testActivateScene() {
        // Set up room
        Mockito.when(mockHomeSystem.getStateValue("currentRoom")).thenReturn("livingRoom");

        // Activate reading scene
        lightSystem.activateScene("reading");

        // Access the internal state of room light levels
        try {
            Field roomLightLevelsField = LightManagementSystem.class.getDeclaredField("roomLightLevels");
            roomLightLevelsField.setAccessible(true);
            Map<String, Integer> roomLightLevels = (Map<String, Integer>) roomLightLevelsField.get(lightSystem);

            // Get the reading scene brightness to verify
            Field lightScenesField = LightManagementSystem.class.getDeclaredField("lightScenes");
            lightScenesField.setAccessible(true);
            Map<String, ?> lightScenes = (Map<String, ?>) lightScenesField.get(lightSystem);
            Object readingScene = lightScenes.get("reading");
            Field brightnessField = readingScene.getClass().getDeclaredField("brightness");
            brightnessField.setAccessible(true);
            int expectedBrightness = (int) brightnessField.get(readingScene);

            // Verify the light level was set as expected
            assertEquals(expectedBrightness, roomLightLevels.get("livingRoom").intValue());
        } catch (Exception e) {
            fail("Failed to access fields: " + e.getMessage());
        }
    }

    @Test
    public void testMotionEventTrigger() {
        // Set up the required state returns
        Mockito.when(mockHomeSystem.getStateValue("currentRoom")).thenReturn("livingRoom");
        Mockito.when(mockHomeSystem.getStateValue("ambientLight")).thenReturn(30);

        // Trigger motion event through observer interface
        lightSystem.onStateChange("motion", false, true);

        // Verify the lights were adjusted for the room
        try {
            Field roomLightLevelsField = LightManagementSystem.class.getDeclaredField("roomLightLevels");
            roomLightLevelsField.setAccessible(true);
            Map<String, Integer> roomLightLevels = (Map<String, Integer>) roomLightLevelsField.get(lightSystem);

            // Verify light level was set
            assertEquals(70, roomLightLevels.get("livingRoom").intValue());
        } catch (Exception e) {
            fail("Failed to access room light levels: " + e.getMessage());
        }
    }
}
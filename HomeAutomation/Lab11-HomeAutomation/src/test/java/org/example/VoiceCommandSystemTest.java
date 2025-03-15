package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import smarthome.core.*;
import smarthome.components.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VoiceCommandSystemTest {

    @Mock
    private HomeSystem mockHomeSystem;

    private VoiceCommandSystem voiceSystem;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        voiceSystem = new VoiceCommandSystem(mockHomeSystem);
    }

    @Test
    public void testTurnOnLightsCommand() {
        // Command to turn on lights
        voiceSystem.processCommand("turn on lights in the living room");

        // Verify the right states were updated
        Mockito.verify(mockHomeSystem).updateState("currentRoom", "livingRoom");

        // Capture and verify the device power map that was updated
        Mockito.verify(mockHomeSystem, Mockito.atLeastOnce()).updateState(
                Mockito.eq("devicePower"),
                Mockito.argThat(arg -> {
                    @SuppressWarnings("unchecked")
                    Map<String, Boolean> deviceStatus = (Map<String, Boolean>) arg;
                    return deviceStatus.containsKey("lighting") && deviceStatus.get("lighting") == true;
                })
        );
    }

    @Test
    public void testTurnOffLightsCommand() {
        // Command to turn off lights
        voiceSystem.processCommand("turn off lights in the bedroom");

        // Verify the right states were updated
        Mockito.verify(mockHomeSystem).updateState("currentRoom", "bedroom");

        // Capture and verify the device power map that was updated
        Mockito.verify(mockHomeSystem, Mockito.atLeastOnce()).updateState(
                Mockito.eq("devicePower"),
                Mockito.argThat(arg -> {
                    @SuppressWarnings("unchecked")
                    Map<String, Boolean> deviceStatus = (Map<String, Boolean>) arg;
                    return deviceStatus.containsKey("lighting") && deviceStatus.get("lighting") == false;
                })
        );
    }

    @Test
    public void testSetTemperatureCommand() {
        // Command to set temperature
        voiceSystem.processCommand("set temperature to 25");

        // Verify temperature was updated
        Mockito.verify(mockHomeSystem).updateState("targetTemperature", 25.0);
    }

    @Test
    public void testActivateSceneCommand() {
        // Command to activate scene
        voiceSystem.processCommand("change to reading scene");

        // Verify light scene was updated
        Mockito.verify(mockHomeSystem).updateState("lightScene", "reading");
    }

    @Test
    public void testInvalidCommandIsTracked() {
        // Process an invalid command
        voiceSystem.processCommand("do something impossible");

        // Command should still be recorded in history
        List<String> history = voiceSystem.getCommandHistory();
        assertEquals(1, history.size());
        assertEquals("do something impossible", history.get(0));
    }

    @Test
    public void testCommandHistoryTracking() {
        // Process multiple commands
        voiceSystem.processCommand("turn on lights");
        voiceSystem.processCommand("set temperature to 23");

        // Verify commands were recorded in order
        List<String> history = voiceSystem.getCommandHistory();
        assertEquals(2, history.size());
        assertEquals("turn on lights", history.get(0));
        assertEquals("set temperature to 23", history.get(1));
    }

    @Test
    public void testRoomExtractionFromCommand() {
        // Set up a mock device status map when needed
        Mockito.when(mockHomeSystem.getStateValue("devicePower")).thenReturn(new HashMap<String, Boolean>());

        // Test different room commands
        voiceSystem.processCommand("turn on lights in the kitchen");
        Mockito.verify(mockHomeSystem).updateState("currentRoom", "kitchen");

        voiceSystem.processCommand("turn on lights in the bathroom");
        Mockito.verify(mockHomeSystem).updateState("currentRoom", "bathroom");

        voiceSystem.processCommand("turn on lights in the bedroom");
        Mockito.verify(mockHomeSystem).updateState("currentRoom", "bedroom");
    }
}
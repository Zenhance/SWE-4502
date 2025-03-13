package VoiceCommand;

import Core.HomeEnvironment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VoiceCommandTest {
    private VoiceCommand voiceCommand;
    private HomeEnvironment homeEnvironment;

    @BeforeEach
    void setUp() {
        voiceCommand = new VoiceCommand();
        homeEnvironment = HomeEnvironment.getInstance();
        homeEnvironment.registerObserver("voiceCommand", voiceCommand);  // Register for "voiceCommand"
    }

    @Test
    void testTurnOnLightCommand() {
        // Simulate sending the "turn on the light" command
        homeEnvironment.setState("voiceCommand", "Turn on the light");

        // Verify the light state is set to "on"
        assertEquals("on", homeEnvironment.getState("lightState"), "The light state should be 'on'.");
    }

    @Test
    void testTurnOffLightCommand() {
        // Simulate sending the "turn off the light" command
        homeEnvironment.setState("voiceCommand", "Turn off the light");

        // Verify the light state is set to "off"
        assertEquals("off", homeEnvironment.getState("lightState"), "The light state should be 'off'.");
    }

    @Test
    void testSetTemperatureCommand() {
        // Simulate sending the "set temperature to 22" command
        homeEnvironment.setState("voiceCommand", "Set temperature to 22");

        // Verify the temperature is set to 22
        assertEquals(22, homeEnvironment.getState("temperature"), "The temperature should be set to 22°C.");
    }

    @Test
    void testOpenDoorCommand() {
        // Simulate sending the "open the door" command
        homeEnvironment.setState("voiceCommand", "Open the door");

        // Verify the door state is set to "open"
        assertEquals("open", homeEnvironment.getState("doorState"), "The door state should be 'open'.");
    }

    @Test
    void testCloseDoorCommand() {
        // Simulate sending the "close the door" command
        homeEnvironment.setState("voiceCommand", "Close the door");

        // Verify the door state is set to "closed"
        assertEquals("closed", homeEnvironment.getState("doorState"), "The door state should be 'closed'.");
    }

    @Test
    void testCommandHistory() {
        // Simulate processing several commands
        homeEnvironment.setState("voiceCommand", "Turn on the light");
        homeEnvironment.setState("voiceCommand", "Set temperature to 22");
        homeEnvironment.setState("voiceCommand", "Open the door");

        // Verify that the command history contains the correct commands
        assertEquals(3, voiceCommand.getCommandHistory().size(), "There should be 3 commands in the history.");
        assertTrue(voiceCommand.getCommandHistory().contains("Turn on the light"), "History should contain 'Turn on the light'.");
        assertTrue(voiceCommand.getCommandHistory().contains("Set temperature to 22"), "History should contain 'Set temperature to 22'.");
        assertTrue(voiceCommand.getCommandHistory().contains("Open the door"), "History should contain 'Open the door'.");
    }

    @Test
    void testUnrecognizedCommand() {
        // Simulate sending an unrecognized command
        homeEnvironment.setState("voiceCommand", "Turn on the music");

        // Verify that the system state is not affected by unrecognized commands
        assertNull(homeEnvironment.getState("musicState"), "No state should be set for 'musicState'.");

        // Verify that the unrecognized command is logged in the history
        assertTrue(voiceCommand.getCommandHistory().contains("Turn on the music"), "History should contain 'Turn on the music'.");
    }

    @Test
    void testCommandHistoryIsUpdated() {
        // Simulate sending commands
        homeEnvironment.setState("voiceCommand", "Turn on the light");
        homeEnvironment.setState("voiceCommand", "Set temperature to 22");
        homeEnvironment.setState("voiceCommand", "Close the door");

        // Verify that the history size increases and contains the commands
        assertEquals(3, voiceCommand.getCommandHistory().size(), "Command history should contain 3 entries.");
    }
}

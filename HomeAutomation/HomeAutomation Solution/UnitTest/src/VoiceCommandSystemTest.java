import VoiceCommandSystem.*;

import CoreFramework.HomeEnvironment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class VoiceCommandSystemTest {
    private VoiceCommandSystem voiceCommandSystem;
    private HomeEnvironment homeEnvironment;

    @BeforeEach
    void setUp() {
        homeEnvironment = HomeEnvironment.getInstance();
        voiceCommandSystem = new VoiceCommandSystem();
    }

    @Test
    void testSetTemperatureCommand() {
        voiceCommandSystem.processCommand("Set temperature to 24");

        assertEquals(24.0, homeEnvironment.getState("targetTemperature"),
                "Target temperature should be updated to 24");

        List<String> history = voiceCommandSystem.getCommandHistory();
        assertFalse(history.isEmpty(), "Command history should not be empty");
        assertEquals("Set temperature to 24", history.get(0), "Command history should record executed command");
    }

    @Test
    void testSetSceneToReadingCommand() {
        voiceCommandSystem.processCommand("Set scene to reading");

        assertEquals("reading", homeEnvironment.getState("lightScene"),
                "Light scene should be set to 'reading'");

        List<String> history = voiceCommandSystem.getCommandHistory();
        assertFalse(history.isEmpty(), "Command history should not be empty");
        assertEquals("Set scene to reading", history.get(0), "Command history should record executed command");
    }

    @Test
    void testSetSceneToMovieCommand() {
        voiceCommandSystem.processCommand("Change scene to movie");

        assertEquals("movie", homeEnvironment.getState("lightScene"),
                "Light scene should be set to 'movie'");
    }

    @Test
    void testToggleRoomOccupancyToFalse() {
        voiceCommandSystem.processCommand("I am leaving");

        assertEquals(false, homeEnvironment.getState("roomOccupancy"),
                "Room occupancy should be set to false when leaving");
    }

    @Test
    void testToggleRoomOccupancyToTrue() {
        voiceCommandSystem.processCommand("I am home");

        assertEquals(true, homeEnvironment.getState("roomOccupancy"),
                "Room occupancy should be set to true when coming home");
    }

    @Test
    void testInvalidCommand() {
        voiceCommandSystem.processCommand("Turn on the TV");

        List<String> history = voiceCommandSystem.getCommandHistory();
        assertTrue(history.isEmpty(), "Invalid commands should not be recorded in history");
    }
}


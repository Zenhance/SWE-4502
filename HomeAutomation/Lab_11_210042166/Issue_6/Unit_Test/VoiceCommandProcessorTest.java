package Lab_11_210042166.Issue_6.Unit_Test;

import Lab_11_210042166.Issue_6.VoiceCommand.VoiceCommandProcessor;
import Lab_11_210042166.Project_Structure.StateManager_Class.StateManager;
import Lab_11_210042166.Project_Structure.Storage_Class.EnvironmentState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VoiceCommandProcessorTest {
    private VoiceCommandProcessor voiceCommandProcessor;
    private StateManager stateManager;

    @BeforeEach
    void setUp() {
        stateManager = new StateManager();
        voiceCommandProcessor = new VoiceCommandProcessor(stateManager);

        // Initialize state with default values
        EnvironmentState initialState = new EnvironmentState(22.0, false, 0, 5.0); // Set an initial environment state
        stateManager.updateState(initialState); // Set the state in the state manager
    }

    @Test
    void testVoiceCommandProcessing() {
        voiceCommandProcessor.processCommand("turn on lights");
        assertTrue(voiceCommandProcessor.getCommandHistory().contains("turn on lights"), "Command history should contain 'turn on lights'");
    }

    @Test
    void testTurnOnLightCommand() {
        voiceCommandProcessor.processCommand("turn on lights");

        assertEquals(100, stateManager.getCurrentState().getLightLevel(), "Lights should be ON after the 'turn on lights' command.");
    }

    @Test
    void testTurnOffLightCommand() {
        voiceCommandProcessor.processCommand("turn off lights");

        assertEquals(0, stateManager.getCurrentState().getLightLevel(), "Lights should be OFF after the 'turn off lights' command.");
    }

    @Test
    void testIncreaseTemperatureCommand() {
        voiceCommandProcessor.processCommand("increase temperature");

        assertEquals(24.0, stateManager.getCurrentState().getTemperature(), "Temperature should increase by 2 degrees after the 'increase temperature' command.");
    }

    @Test
    void testDecreaseTemperatureCommand() {
        voiceCommandProcessor.processCommand("decrease temperature");

        assertEquals(20.0, stateManager.getCurrentState().getTemperature(), "Temperature should decrease by 2 degrees after the 'decrease temperature' command.");
    }

    @Test
    void testUnknownCommand() {
        voiceCommandProcessor.processCommand("unknown command");

        assertTrue(voiceCommandProcessor.getCommandHistory().contains("unknown command"), "Command history should contain 'unknown command'.");
        assertEquals(22.0, stateManager.getCurrentState().getTemperature(), "Temperature should remain the same after an unknown command.");
    }
}

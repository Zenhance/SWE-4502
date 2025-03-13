import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import models.EnvironmentState;
import subjects.HomeAutomationSystem;
import services.VoiceCommandProcessor;

public class VoiceCommandProcessorTest {
    private HomeAutomationSystem homeAutomationSystem;
    private VoiceCommandProcessor voiceCommandProcessor;
    private EnvironmentState environmentState;

    @BeforeEach
    void setUp() {
        homeAutomationSystem = mock(HomeAutomationSystem.class);
        environmentState = new EnvironmentState();

        when(homeAutomationSystem.getEnvironmentState()).thenReturn(environmentState);

        voiceCommandProcessor = new VoiceCommandProcessor(homeAutomationSystem);
    }

    @Test
    public void testTurnOnLightsCommand() {
        voiceCommandProcessor.processCommand("turn on the lights");
        assertEquals(100, environmentState.getLightLevel());
    }

    @Test
    public void testTurnOffLightsCommand() {
        voiceCommandProcessor.processCommand("turn off the lights");
        assertEquals(0, environmentState.getLightLevel());
    }

    @Test
    public void testIncreaseTemperatureCommand() {
        environmentState.setTemperature(22.0); // Initial temperature
        voiceCommandProcessor.processCommand("increase temperature");
        assertEquals(24.0, environmentState.getTemperature());
    }

    @Test
    public void testDecreaseTemperatureCommand() {
        environmentState.setTemperature(22.0); // Initial temperature
        voiceCommandProcessor.processCommand("decrease temperature");
        assertEquals(20.0, environmentState.getTemperature());
    }

    @Test
    public void testUnknownCommand() {
        // Testing an unrecognized command should not change the environment state
        environmentState.setTemperature(22.0);
        environmentState.setLightLevel(50);

        voiceCommandProcessor.processCommand("play music");

        assertEquals(22.0, environmentState.getTemperature()); // Temperature remains unchanged
        assertEquals(50, environmentState.getLightLevel()); // Light level remains unchanged
    }
}

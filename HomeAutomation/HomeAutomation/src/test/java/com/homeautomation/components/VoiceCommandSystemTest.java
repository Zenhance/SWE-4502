package com.homeautomation.components;

import com.homeautomation.core.Component;
import com.homeautomation.core.EnvironmentalState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class VoiceCommandSystemTest {
    private VoiceCommandSystem voiceCommandSystem;
    private Component mockComponent;

    @BeforeEach
    public void setUp() {
        voiceCommandSystem = new VoiceCommandSystem();
        mockComponent = mock(Component.class);
        voiceCommandSystem.registerComponent(mockComponent);
    }

    @Test
    public void testTurnOnLightsCommand() {
        voiceCommandSystem.processVoiceCommand("turn on lights");

        verify(mockComponent).updateState(argThat(state -> state.getLightLevel() == 100));
    }

    @Test
    public void testTurnOffLightsCommand() {
        voiceCommandSystem.processVoiceCommand("turn off lights");

        verify(mockComponent).updateState(argThat(state -> state.getLightLevel() == 0));
    }

    @Test
    public void testIncreaseTemperatureCommand() {
        voiceCommandSystem.processVoiceCommand("increase temperature");

        verify(mockComponent).updateState(argThat(state -> state.getTemperature() == 2)); // Default starts at 0
    }

    @Test
    public void testDecreaseTemperatureCommand() {
        voiceCommandSystem.processVoiceCommand("decrease temperature");

        verify(mockComponent).updateState(argThat(state -> state.getTemperature() == -2)); // Default starts at 0
    }

    @Test
    public void testUnknownCommand() {
        voiceCommandSystem.processVoiceCommand("play music");

        verifyNoInteractions(mockComponent);
    }
}

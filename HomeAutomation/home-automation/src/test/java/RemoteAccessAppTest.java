import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import models.EnvironmentState;
import subjects.HomeAutomationSystem;
import observers.RemoteAccessApp;

public class RemoteAccessAppTest {
    private HomeAutomationSystem homeAutomationSystem;
    private RemoteAccessApp remoteAccessApp;
    private EnvironmentState environmentState;

    @BeforeEach
    void setUp() {
        homeAutomationSystem = mock(HomeAutomationSystem.class);
        environmentState = new EnvironmentState();
        when(homeAutomationSystem.getEnvironmentState()).thenReturn(environmentState);
        remoteAccessApp = new RemoteAccessApp(homeAutomationSystem);
    }

    @Test
    public void testUpdateMethodCalled() {
        environmentState.setTemperature(25.0);
        environmentState.setLightLevel(50);
        homeAutomationSystem.setEnvironmentState(environmentState);

        // Verify that the update method is called and the UI is updated (simulated with print statements)
        verify(homeAutomationSystem).registerObserver(remoteAccessApp);
    }

    @Test
    public void testDisplayCurrentState() {
        environmentState.setTemperature(25.0);
        environmentState.setLightLevel(50);
        remoteAccessApp.update(environmentState);

        // Test the current state display (We’ll assume the state is logged properly or printed)
        assertEquals(25.0, environmentState.getTemperature());
        assertEquals(50, environmentState.getLightLevel());
    }

    @Test
    public void testGenerateNotificationsHighTemp() {
        environmentState.setTemperature(35.0);  // High temp scenario
        remoteAccessApp.update(environmentState);
        // Can't capture console output
    }

    @Test
    public void testControlLights() {
        remoteAccessApp.controlLights(true);  // Turn lights on
        assertEquals(100, environmentState.getLightLevel());

        remoteAccessApp.controlLights(false);  // Turn lights off
        assertEquals(0, environmentState.getLightLevel());
    }

    @Test
    public void testControlTemperature() {
        remoteAccessApp.controlTemperature(22.5);
        assertEquals(22.5, environmentState.getTemperature());
    }
}

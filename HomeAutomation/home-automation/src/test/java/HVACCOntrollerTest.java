import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import observers.HVACController;
import subjects.HomeAutomationSystem;
import models.EnvironmentState;

public class HVACControllerTest {
    // Mock Instances
    @Mock
    private HVACController mockHVACController;

    // Actual Instances
    private HVACController hvacController;
    private HomeAutomationSystem homeAutomationSystem;

    @BeforeEach
    void setUp() {
        homeAutomationSystem = new HomeAutomationSystem();
        mockHVACController = mock(HVACController.class);
        hvacController = new HVACController(22.0);

        homeAutomationSystem.registerObserver(mockHVACController);
        homeAutomationSystem.registerObserver(hvacController);
    }

    @Test
    public void testUpdateMethodCalled() {
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.setTemperature(25.0);
        homeAutomationSystem.setEnvironmentState(environmentState);

        verify(mockHVACController).update(any());
    }

    @Test
    public void testHeatingTurnsOnWhenTooCold() {
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.setTemperature(19.5);
        homeAutomationSystem.setEnvironmentState(environmentState);

        assertTrue(hvacController.isHeatingOn());
        assertFalse(hvacController.isCoolingOn());
    }

    @Test
    public void testCoolingTurnsOnWhenTooHot() {
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.setTemperature(25.0);
        homeAutomationSystem.setEnvironmentState(environmentState);

        assertTrue(hvacController.isCoolingOn());
        assertFalse(hvacController.isHeatingOn());
    }

    @Test
    public void testSetTargetTemperature() {
        hvacController.setTargetTemperature(24.0);
        assertEquals(24.0, hvacController.getTargetTemperature());
    }
}

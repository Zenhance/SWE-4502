import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import observers.HVACController;
import subjects.HomeAutomationSystem;
import models.EnvironmentState;

public class HVACCOntrollerTest {
    @Mock
    private HVACController mockHVACController;
    private HVACController HVACController;
    private HomeAutomationSystem homeAutomationSystem;

    @BeforeEach
    void setUp() {
        homeAutomationSystem = new HomeAutomationSystem();
        mockHVACController = mock(HVACController.class);
        HVACController = new HVACController(22.0);
        homeAutomationSystem.registerObserver(mockHVACController);
        homeAutomationSystem.registerObserver(HVACController);
    }

    @Test
    public void testUpdateMethodCalled() {
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.setTemperature(25.0);
        homeAutomationSystem.setEnvironmentState(environmentState);
        verify(mockHVACController).update(any());
    }

    @Test
    public void testHeatingOn() {
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.setTemperature(19.5);
        homeAutomationSystem.setEnvironmentState(environmentState);
        assertEquals(true, HVACController.isHeatingOn());
    }

    @Test
    public void testCoolingOn() {
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.setTemperature(25.0);
        homeAutomationSystem.setEnvironmentState(environmentState);
        assertEquals(true, HVACController.isCoolingOn());
    }

    @Test
    public void testSetTargetTemperature() {
        HVACController.setTargetTemperature(24.0);
        assertEquals(24.0, HVACController.getTargetTemperature());
    }
}

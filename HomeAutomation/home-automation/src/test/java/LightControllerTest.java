import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import observers.LightController;
import subjects.HomeAutomationSystem;
import models.EnvironmentState;

public class LightControllerTest {
    // Mock Instances
    @Mock
    private LightController mockLightController;
    // Actual Instances
    private LightController lightController;
    private HomeAutomationSystem homeAutomationSystem;

    @BeforeEach
    void setUp(){
        homeAutomationSystem = new HomeAutomationSystem();
        mockLightController = mock(LightController.class);
        lightController = new LightController();
        homeAutomationSystem.registerObserver(mockLightController);
        homeAutomationSystem.registerObserver(lightController);
    }

    @Test
    public void testUpdateMethodCalled() {
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.setLightLevel(75);
        homeAutomationSystem.setEnvironmentState(environmentState);
        verify(mockLightController).update(any());
    }

    @Test
    public void testLightLevel() {
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.setLightLevel(75);
        homeAutomationSystem.setEnvironmentState(environmentState);
        assertEquals(75, lightController.getLightLevel());
    }
}

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import models.EnvironmentState;
import subjects.HomeAutomationSystem;
import observers.HVACController;
import observers.LightController;
import observers.RemoteAccessApp;

public class IntegrationTest {
    private HomeAutomationSystem homeAutomationSystem;
    private HVACController hvacController;
    private LightController lightController;
    private RemoteAccessApp remoteAccessApp;
    private EnvironmentState environmentState;

    @BeforeEach
    void setUp() {
        homeAutomationSystem = new HomeAutomationSystem();
        hvacController = spy(new HVACController(22.0));
        lightController = spy(new LightController());
        remoteAccessApp = spy(new RemoteAccessApp(homeAutomationSystem));

        homeAutomationSystem.registerObserver(hvacController);
        homeAutomationSystem.registerObserver(lightController);
        homeAutomationSystem.registerObserver(remoteAccessApp);

        environmentState = new EnvironmentState();
    }

    @Test
    public void testMultipleObserversReceiveUpdates() {
        environmentState.setTemperature(18.0);
        environmentState.setLightLevel(70);
        homeAutomationSystem.setEnvironmentState(environmentState);

        verify(hvacController).update(environmentState);
        verify(lightController).update(environmentState);
        verify(remoteAccessApp).update(environmentState);
    }

    @Test
    public void testObserversReactToStateChanges() {
        environmentState.setTemperature(16.0);
        homeAutomationSystem.setEnvironmentState(environmentState);
        assertTrue(hvacController.isHeatingOn());

        environmentState.setTemperature(26.0);
        homeAutomationSystem.setEnvironmentState(environmentState);
        assertTrue(hvacController.isCoolingOn());
    }

}

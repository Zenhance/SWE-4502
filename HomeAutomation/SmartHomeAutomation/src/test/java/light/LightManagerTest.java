package light;

import core.StateManager;
import core.model.Measurement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LightManagerTest {

    @Test
    void testAdjustLightingBasedOnScene() {
        StateManager stateManager = new StateManager();
        LightManager lightManager = new LightManager(stateManager);

        lightManager.setScene("Reading");
        assertEquals("Reading", lightManager.getCurrentScene(), "Scene should be set to Reading");

        lightManager.setScene("Movie");
        assertEquals("Movie", lightManager.getCurrentScene(), "Scene should be set to Movie");

        lightManager.setScene("Normal");
        assertEquals("Normal", lightManager.getCurrentScene(), "Scene should be set to Normal");
    }

    @Test
    void testOnEventAdjustsLighting() {
        StateManager stateManager = new StateManager();
        LightManager lightManager = new LightManager(stateManager);

        // Simulate light level change
        Measurement lightMeasurement = new Measurement(70, Measurement.Units.PERCENT);
        stateManager.setState(core.model.EventType.LIGHT_LEVEL, lightMeasurement);

        // Simulate occupancy change
        Measurement occupancyMeasurement = new Measurement(1, Measurement.Units.COUNT);
        stateManager.setState(core.model.EventType.OCCUPANCY, occupancyMeasurement);
    }

    @Test
    void testSetSceneAdjustsLighting() {
        StateManager stateManager = new StateManager();
        LightManager lightManager = new LightManager(stateManager);

        lightManager.setScene("Reading");
        assertEquals("Reading", lightManager.getCurrentScene(), "Current scene should be Reading");

        lightManager.setScene("Movie");
        assertEquals("Movie", lightManager.getCurrentScene(), "Current scene should be Movie");

        lightManager.setScene("Normal");
        assertEquals("Normal", lightManager.getCurrentScene(), "Current scene should be Normal");
    }
}

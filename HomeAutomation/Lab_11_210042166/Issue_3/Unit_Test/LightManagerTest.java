package Lab_11_210042166.Issue_3.Unit_Test;

import Lab_11_210042166.Issue_3.LightManagement_Class.LightManager;
import Lab_11_210042166.Project_Structure.StateManager_Class.StateManager;
import Lab_11_210042166.Project_Structure.Storage_Class.EnvironmentState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LightManagerTest {
    private LightManager lightManager;
    private StateManager stateManager;

    @BeforeEach
    void setUp() {
        lightManager = new LightManager(LightManager.LOW_LIGHT_THRESHOLD);
        stateManager = new StateManager();
        stateManager.registerComponent(lightManager);
    }

    @Test
    void testLightsTurnOnWhenLightLevelBelowThresholdAndOccupied() {
        EnvironmentState testState = new EnvironmentState(30.0, true, 40, 500.0); // Added powerUsage
        stateManager.updateState(testState);

        assertTrue(lightManager.areLightsOn(), "Lights should be ON when light level is below threshold and room is occupied.");
    }

    @Test
    void testLightsTurnOffWhenLightLevelAboveThresholdOrNoOccupancy() {
        EnvironmentState testState = new EnvironmentState(30.0, false, 60, 550.0); // Added powerUsage
        stateManager.updateState(testState);

        assertFalse(lightManager.areLightsOn(), "Lights should be OFF when no one is in the room or light level is sufficient.");
    }

    @Test
    void testSetSceneToMovie() {
        lightManager.setScene("movie");
        EnvironmentState testState = new EnvironmentState(40.0, true, 40, 520.0); // Added powerUsage
        stateManager.updateState(testState);
    }

    @Test
    void testSetSceneToReading() {
        lightManager.setScene("reading");
        EnvironmentState testState = new EnvironmentState(30.0, true, 40, 530.0); // Added powerUsage
        stateManager.updateState(testState);
    }

    @Test
    void testNoChangeWhenNoOccupancy() {
        EnvironmentState firstState = new EnvironmentState(30.0, true, 40, 540.0); // Added powerUsage
        stateManager.updateState(firstState);
        assertTrue(lightManager.areLightsOn(), "Lights should be ON initially.");

        EnvironmentState secondState = new EnvironmentState(30.0, false, 40, 550.0); // Added powerUsage
        stateManager.updateState(secondState);
        assertFalse(lightManager.areLightsOn(), "Lights should turn OFF when room is not occupied.");
    }
}

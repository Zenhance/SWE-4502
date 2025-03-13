import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LightManagementTest {
    @Test
    void testLightTurnOn(){
        LightManager lightManager = new LightManager();
        EnvironmentState state = new EnvironmentState();

        state.updateState("lightLevel", 20);
        state.updateState("occupancy", true);

        lightManager.update(state);
        assertTrue(lightManager.areLightsOn(), "Lights should be on when occupancy is true and light level is low");
    }
    @Test
    void testLightTurnOff(){
        LightManager lightManager = new LightManager();
        EnvironmentState state = new EnvironmentState();

        state.updateState("lightLevel", 50);
        state.updateState("occupancy", false);

        lightManager.update(state);
        assertFalse(lightManager.areLightsOn(), "Lights should be off when occupancy is false or light level is high");
    }
}

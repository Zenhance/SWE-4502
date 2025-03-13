import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LightManagerTest {

    @Test
    void testLightAdjustmentBasedOnOccupancy() {
        LightManager manager = new LightManager();


        EnvironmentalState unoccupiedState = new EnvironmentalState();
        unoccupiedState.roomOccupied=false;
        unoccupiedState.lightLevel=0;
        manager.update(unoccupiedState);
        assertEquals(0, manager.getBrightnessLevel(), "Lights should be off when room is unoccupied");
    }

    @Test
    void testLightAdjustmentBasedOnAmbientLight() {
        LightManager manager = new LightManager();


        EnvironmentalState lowLightState = new EnvironmentalState();
        lowLightState.lightLevel=20;
        lowLightState.roomOccupied=true;
        manager.update(lowLightState);

        assertTrue(manager.getBrightnessLevel() > 50, "Brightness should increase in low light");


        EnvironmentalState highLightState = new EnvironmentalState();
        highLightState.lightLevel=90;
        manager.update(highLightState);
        assertTrue(manager.getBrightnessLevel() < 70, "Brightness should reduce in high light");
    }

    @Test
    void testSceneChange() {
        LightManager manager = new LightManager();
        EnvironmentalState state = new EnvironmentalState();
        state.roomOccupied=true;
        manager.update(state);

        manager.setScene("reading");
        assertEquals(100, manager.getBrightnessLevel(), "Brightness should be 100 for reading scene");

        manager.setScene("movie");
        assertEquals(30, manager.getBrightnessLevel(), "Brightness should be 30 for movie scene");


        manager.setScene("invalid_scene");
        assertNotEquals(0, manager.getBrightnessLevel(), "Invalid scene should not affect brightness");
    }
}

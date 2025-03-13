import Issue1.StateManager;
import Issue3.BrightnessListener;
import Issue3.LightController;
import Issue3.NormalLightingStrategy;
import Issue3.ReadingLightingStrategy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Issue3Test {

    private StateManager stateManager;
    private LightController lightController;
    private BrightnessListener brightnessListener;



    @Before
    public void setUp() {

       stateManager = new StateManager();
        lightController = new LightController(stateManager);

        brightnessListener = new BrightnessListener();

        stateManager.registerComponent("brightness", brightnessListener);





    }

    @Test
    public void testLightLevel(){

        stateManager.updateState("light_level", 80);
        assertTrue(lightController.getBrightness() < 50);
        assertEquals(lightController.getBrightness(), brightnessListener.getLastBrightness())   ;


    }


    @Test
    public void testRoomOccupancy(){

        NormalLightingStrategy normalLightingStrategy = new NormalLightingStrategy();

        stateManager.updateState("room_occupancy", true);

        lightController.adjustLighting();


        int occupiedbrightness=lightController.getBrightness();

        stateManager.updateState("room_occupancy", false);

        lightController.adjustLighting();

        int unoccupiedbrightness=lightController.getBrightness();

      assertTrue(occupiedbrightness>unoccupiedbrightness);

      assertEquals(unoccupiedbrightness, brightnessListener.getLastBrightness() );



    }

    @Test
    public void testLightingSceneEffect() {
        stateManager.updateState("room_occupancy", true);
        stateManager.updateState("light_level", 50);


        lightController.setLightingSceneStrategy(new ReadingLightingStrategy());
        lightController.adjustLighting();
        int readingBrightness = lightController.getBrightness();

        lightController.setLightingSceneStrategy(new NormalLightingStrategy());

        lightController.adjustLighting();
        int normalBrightness = lightController.getBrightness();

        assertTrue(readingBrightness > normalBrightness);
        assertEquals(normalBrightness, brightnessListener.getLastBrightness());
    }










}

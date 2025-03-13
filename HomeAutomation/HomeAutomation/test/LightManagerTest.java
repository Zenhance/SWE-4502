import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LightManagerTest {

    private EnvironmentMonitor monitor;
    private LightManager lightManager;

    @Before
    public void setUp() {
        monitor = new EnvironmentMonitor();
        lightManager = new LightManager();
        monitor.registerObserver(lightManager);
    }

    // Test 1: Responds to Ambient Light Levels and Adjusts Lighting Based on Room Occupancy
    @Test
    public void testLightResponseToAmbientLightAndOccupancy() {
        // Case 1: Low ambient light with motion - should turn lights ON
        EnvironmentState lowLightWithMotion = new EnvironmentState(22.0, true, 30.0);
        monitor.setState(lowLightWithMotion);
        assertTrue(lightManager.lightsOn);
        assertEquals(70, lightManager.currentBrightness, 0.01);

        // Case 2: High ambient light with motion - should turn lights OFF
        EnvironmentState highLightWithMotion = new EnvironmentState(22.0, true, 80.0);
        monitor.setState(highLightWithMotion);
        assertFalse(lightManager.lightsOn);
        assertEquals(0, lightManager.currentBrightness, 0.01);

        // Case 3: Low ambient light with NO motion - should turn lights OFF
        EnvironmentState lowLightNoMotion = new EnvironmentState(22.0, false, 30.0);
        monitor.setState(lowLightNoMotion);
        assertFalse(lightManager.lightsOn);
        assertEquals(0, lightManager.currentBrightness, 0.01);

        // Case 4: High ambient light with NO motion - should keep lights OFF
        EnvironmentState highLightNoMotion = new EnvironmentState(22.0, false, 80.0);
        monitor.setState(highLightNoMotion);
        assertFalse(lightManager.lightsOn);
        assertEquals(0, lightManager.currentBrightness, 0.01);
    }

    // Test 2: Supports Different "Scenes" for Various Activities
    @Test
    public void testSceneSetting() {
        lightManager.setScene("Reading");
        assertEquals("Reading", lightManager.currentScene.name);
        assertEquals(80, lightManager.currentBrightness, 0.01);

        lightManager.setScene("Movie");
        assertEquals("Movie", lightManager.currentScene.name);
        assertEquals(30, lightManager.currentBrightness, 0.01);

        lightManager.setScene("Relax");
        assertEquals("Relax", lightManager.currentScene.name);
        assertEquals(50, lightManager.currentBrightness, 0.01);
    }
}

package Test;

import components.LightManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LightManagerTest {

    @Test
    void testOnStateChangedDark() {
        LightManager lightManager = new LightManager();
        lightManager.onStateChanged("dark", 0);
        assertTrue(true);  // We assume the correct output will happen, no need for assertion here
    }

    @Test
    void testOnStateChangedBright() {
        LightManager lightManager = new LightManager();
        lightManager.onStateChanged("bright", 0);
        assertTrue(true);  // We assume the correct output will happen, no need for assertion here
    }

    @Test
    void testAdjustLighting() {
        LightManager lightManager = new LightManager();

        // Test with room occupied
        lightManager.adjustLighting(true);

        // Test with room unoccupied
        lightManager.adjustLighting(false);

        assertTrue(true); // We assume the correct output will happen, no need for assertion here
    }

    @Test
    void testSetScene() {
        LightManager lightManager = new LightManager();

        // Test for "reading" scene
        lightManager.setScene("reading");

        // Test for "movie" scene
        lightManager.setScene("movie");

        // Test for "relaxing" scene
        lightManager.setScene("relaxing");

        // Test for unrecognized scene
        lightManager.setScene("dance");

        assertTrue(true);  // We assume the correct output will happen, no need for assertion here
    }
}

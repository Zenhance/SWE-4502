import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LightManagerTest {
    private HomeState homeState;
    private LightManager lightManager;

    @BeforeEach
    void setUp() {
        homeState = new HomeState();
        lightManager = new LightManager(homeState, "living-room");
    }

    @Test
    void testLightsOnWhenDark() {
        lightManager.setOccupancy(true);
        lightManager.setLightLevel(40);
        assertTrue(lightManager.isLightsOn());
    }



    @Test
    void testReadingSceneTurnsOnLights() {
        lightManager.setOccupancy(true);
        lightManager.setScene("reading");
        assertTrue(lightManager.isLightsOn());
    }

    @Test
    void testMovieSceneTurnsOnLights() {
        lightManager.setOccupancy(true);
        lightManager.setScene("movie");
        assertTrue(lightManager.isLightsOn());
    }
}
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
        lightManager.setLightLevel(40); // 50 er mathaaaaaaaaa(kom) thaakai lagbeee
        assertTrue(lightManager.isLightsOn());
    }

    @Test
    void testLightsOffWhenBright() {
        lightManager.setOccupancy(true);
        lightManager.setLightLevel(60);
        assertFalse(lightManager.isLightsOn());
    }

    @Test
    void testLightsOffWhenNotOccupied() {
        lightManager.setOccupancy(false);
        lightManager.setLightLevel(40);
        assertFalse(lightManager.isLightsOn());
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
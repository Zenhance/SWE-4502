import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TemperatureControllerTest {
    private HomeState homeState;
    private TemperatureController tempController;

    @BeforeEach
    void setUp() {
        homeState = new HomeState();
        tempController = new TemperatureController(homeState, "kitchen");
    }

    @Test
    void testHeatingOnWhenCold() {
        tempController.setTemperature(18);
        assertTrue(tempController.isHeatingOn());
        assertFalse(tempController.isCoolingOn());
    }

    @Test
    void testCoolingOnWhenHot() {
        tempController.setTemperature(22);
        assertFalse(tempController.isHeatingOn());
        assertTrue(tempController.isCoolingOn());
    }

    @Test
    void testBothOffInRange() {
        tempController.setTemperature(20);
        assertFalse(tempController.isHeatingOn());
        assertFalse(tempController.isCoolingOn());
    }
}
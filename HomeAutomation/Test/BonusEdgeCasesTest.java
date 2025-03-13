import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BonusEdgeCasesTest {
    private HomeState homeState;
    private TemperatureController tempController;

    @BeforeEach
    void setUp() {
        homeState = new HomeState();
        tempController = new TemperatureController(homeState, "room");
    }

    @Test
    void testNegativeTemperature() {
        homeState.setState("temp-room", -10);
        assertTrue(tempController.isHeatingOn());
    }
}
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TemperatureControllerTest {
    @Test
    void testTemperatureRegulation() {
        TemperatureController controller = new TemperatureController();
        EnvironmentalState state = new EnvironmentalState();
        state.temperature=16;
        controller.update(state);
        assertEquals(16, controller.getCurrentTemperature());
        state.temperature=30;
        controller.update(state);
        assertEquals(30, controller.getCurrentTemperature());
    }
}

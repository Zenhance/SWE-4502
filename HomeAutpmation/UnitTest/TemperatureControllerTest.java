import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TemperatureControllerTest {

    private TemperatureController temperatureController;
    private SystemState systemState;

    @BeforeEach
    public void setUp() {
        temperatureController = new TemperatureController();
        systemState = new SystemState();
    }

    @Test
    public void testActivateHeatingWhenTemperatureIsLow() {
        systemState.setStateDescription("15.0");
        temperatureController.update(systemState);
        assertEquals("Temperature is low. Activating heating...", temperatureController.getLastAction());
    }





}

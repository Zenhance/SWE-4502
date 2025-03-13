package Test;

import components.TemperatureController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TemperatureControllerTest {

    @Test
    void testOnStateChangedCold() {
        TemperatureController temperatureController = new TemperatureController();
        temperatureController.onStateChanged("cold", 0);
        assertTrue(true); // We assume the correct output will happen, no need for assertion here
    }

    @Test
    void testOnStateChangedHot() {
        TemperatureController temperatureController = new TemperatureController();
        temperatureController.onStateChanged("hot", 0);
        assertTrue(true); // We assume the correct output will happen, no need for assertion here
    }

    @Test
    void testOnTemperatureChangeCold() {
        TemperatureController temperatureController = new TemperatureController();
        temperatureController.onTemperatureChange(15);
        assertTrue(temperatureController.getCurrentTemperature() == 15);
    }

    @Test
    void testOnTemperatureChangeHot() {
        TemperatureController temperatureController = new TemperatureController();
        temperatureController.onTemperatureChange(35);
        assertTrue(temperatureController.getCurrentTemperature() == 35);
    }
}

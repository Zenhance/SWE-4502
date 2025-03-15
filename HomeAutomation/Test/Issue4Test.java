import Issue1.StateManager;
import Issue4.HVACController;
import Issue4.TemperatureSensor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Issue4Test {

    private StateManager stateManager;
    private TemperatureSensor sensor;
    private HVACController controller;

    @Before
    public void setup() {
        stateManager = new StateManager();
        sensor = new TemperatureSensor(stateManager);
        controller = new HVACController(stateManager, 22.0, 1.0);
    }

    @Test
    public void testHeatingCommand() {
        sensor.readTemperature(20.0);
        assertEquals(HVACController.MODE_HEATING, stateManager.getState(HVACController.MODE_KEY));
    }

    @Test
    public void testCoolingCommand() {
        sensor.readTemperature(24.0);
        assertEquals(HVACController.MODE_COOLING, stateManager.getState(HVACController.MODE_KEY));
    }

    @Test
    public void testStopHVACCommand() {
        sensor.readTemperature(24.0);
        sensor.readTemperature(22.0);
        assertEquals(HVACController.MODE_OFF, stateManager.getState(HVACController.MODE_KEY));
    }

    @Test
    public void testHysteresisEffect() {
        sensor.readTemperature(23.5);
        assertEquals(HVACController.MODE_COOLING, stateManager.getState(HVACController.MODE_KEY));

        sensor.readTemperature(21.5);
        assertEquals(HVACController.MODE_OFF, stateManager.getState(HVACController.MODE_KEY));

        sensor.readTemperature(20.5);
        assertEquals(HVACController.MODE_HEATING, stateManager.getState(HVACController.MODE_KEY));
    }




}

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TemperatureControllerTest {

    private EnvironmentMonitor monitor;
    private TemperatureController tempController;

    @Before
    public void setUp() {
        monitor = new EnvironmentMonitor();
        tempController = new TemperatureController(22.0); // Target temperature set to 22°C
        monitor.registerObserver(tempController);
    }

    // Test 1: Monitors Current Temperature and Activates Heating
    @Test
    public void testActivatesHeatingWhenTemperatureIsLow() {
        EnvironmentState coldState = new EnvironmentState(21.0, false, 50.0);
        monitor.setState(coldState);

        assertTrue(tempController.heatingOn);
        assertFalse(tempController.coolingOn);
    }

    // ✅ Test 2: Activates Cooling When Temperature Is High
    @Test
    public void testActivatesCoolingWhenTemperatureIsHigh() {
        EnvironmentState hotState = new EnvironmentState(23.0, false, 50.0);
        monitor.setState(hotState);

        assertTrue(tempController.coolingOn);
        assertFalse(tempController.heatingOn);
    }

    // ✅ Test 3: Hysteresis Prevents Rapid Switching (No Action within Range)
    @Test
    public void testHysteresisPreventsRapidSwitching() {
        // Within hysteresis range (no heating or cooling)
        EnvironmentState withinRangeState = new EnvironmentState(22.3, false, 50.0);
        monitor.setState(withinRangeState);

        assertFalse(tempController.heatingOn);
        assertFalse(tempController.coolingOn);
    }

}
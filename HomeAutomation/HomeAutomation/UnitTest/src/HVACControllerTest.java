import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HVACControllerTest
{

    @Test
    public void testCoolingSystem()
    {
        HVACController hvacController = new HVACController();
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.setTemperature(30);

        hvacController.update(environmentState);
        assertEquals(30, hvacController.targetTemperature);
    }

    @Test
    public void testHeatingSystem()
    {
        HVACController hvacController = new HVACController();
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.setTemperature(18);

        hvacController.update(environmentState);
        assertEquals(18, hvacController.targetTemperature);
    }

    @Test
    public void testTemperatureBoundary()
    {
        HVACController hvacController = new HVACController();
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.setTemperature(25);

        hvacController.update(environmentState);
        assertEquals(25, hvacController.targetTemperature);
    }
}

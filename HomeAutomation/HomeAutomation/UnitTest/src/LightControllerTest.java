import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LightControllerTest
{

    @Test
    public void testLightOn()
    {
        LightController lightController = new LightController();
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.setLightLevel(40);

        lightController.update(environmentState); // Should turn on lights
        assertEquals(40, lightController.lightLevel);
    }

    @Test
    public void testLightOff()
    {
        LightController lightController = new LightController();
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.setLightLevel(60);

        lightController.update(environmentState);
        assertEquals(60, lightController.lightLevel);
    }

    @Test
    public void testLightBoundary()
    {
        LightController lightController = new LightController();
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.setLightLevel(50);

        lightController.update(environmentState);
        assertEquals(50, lightController.lightLevel);
    }
}


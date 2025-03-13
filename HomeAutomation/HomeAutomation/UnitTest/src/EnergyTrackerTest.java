import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnergyTrackerTest
{

    @Test
    public void testEnergyTracking()
    {
        EnergyTracker energyTracker = new EnergyTracker();
        HVACController hvacController = new HVACController();

        energyTracker.trackEnergyUsage(hvacController);
        assertEquals(100, energyTracker.getEnergyConsumption());
    }

    @Test
    public void testLightEnergyTracking()
    {
        EnergyTracker energyTracker = new EnergyTracker();
        LightController lightController = new LightController();

        energyTracker.trackEnergyUsage(lightController);
        assertEquals(50, energyTracker.getEnergyConsumption());
    }

    @Test
    public void testZeroEnergyConsumption()
    {
        EnergyTracker energyTracker = new EnergyTracker();

        assertEquals(0, energyTracker.getEnergyConsumption());
    }
}

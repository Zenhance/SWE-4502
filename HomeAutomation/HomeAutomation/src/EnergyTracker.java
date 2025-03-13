public class EnergyTracker
{
    private int energyConsumption;

    public void trackEnergyUsage(Observer device)
    {
        if (device instanceof HVACController)
        {
            energyConsumption += 100;
        } else if (device instanceof LightController)
        {
            energyConsumption += 50;
        }
    }

    public int getEnergyConsumption()
    {
        return energyConsumption;
    }
}


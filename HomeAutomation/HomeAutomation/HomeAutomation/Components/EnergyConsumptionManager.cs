using HomeAutomation.ENUM;
using HomeAutomation.Interface;
using HomeAutomation.Models;

namespace HomeAutomation.Components;

public class EnergyConsumptionManager: ISmartHomeComponent
{
    
    private List<PowerConsumptionData> powerConsumptionData;
    private float threshold;
    
    public EnergyConsumptionManager(float threshold)
    {
        powerConsumptionData = new List<PowerConsumptionData>();
        this.threshold = threshold;
    }
    
    public void update(SENSOR sensor, Command command)
    {
        float value = command.getValue();
        if (sensor == SENSOR.ENERGY)
        {
            powerConsumptionData.Add(new PowerConsumptionData(value));
        }
    }

    public CONSUMPTIONPATTERN getPattern()
    {
        foreach (PowerConsumptionData pcd in powerConsumptionData)
        {
            if (pcd.getConsumption() > threshold)
            {
                return CONSUMPTIONPATTERN.UNUSUAL;
            }
        }
        
        return CONSUMPTIONPATTERN.USUAL;
    }
    
    public List<PowerConsumptionData> GetPowerConsumptionData()
    {
        return powerConsumptionData;
    }
    
    public float getThreshold()
    {
        return threshold;
    }

    public PowerConsumptionData getLastData()
    {
        return powerConsumptionData[powerConsumptionData.Count - 1];
    }
}
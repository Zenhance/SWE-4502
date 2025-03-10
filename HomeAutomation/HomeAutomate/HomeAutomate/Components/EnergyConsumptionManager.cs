using HomeAutomate.Enum;
using HomeAutomate.Interfaces;
using HomeAutomate.Models;

namespace HomeAutomate.Components;

public class EnergyConsumptionManager : ISmartHomeComponent
{
    private List<PowerConsumptionData> _consumptionData;
    private float _threshold;
    
    public EnergyConsumptionManager(float threshold)
    {
        _consumptionData = new List<PowerConsumptionData>();
        _threshold = threshold;
    }
    
    public void update(SENSOR sensor, Command command)
    {
        float value = command.getValue();
        if (sensor == SENSOR.ENERGY)
        {
            _consumptionData.Add(new PowerConsumptionData(value));
        }
    }
    

        
    public CONSUMPTIONPATTERN getConsumptionPattern()
    {

        foreach(PowerConsumptionData pcd in _consumptionData)
        {
            if (pcd.getConsumption() > _threshold)
            {
                return CONSUMPTIONPATTERN.UNUSUAL;
            }
        }

        return CONSUMPTIONPATTERN.USUAL;
    }
    
    public List<PowerConsumptionData> getStatistics()
    {
        return _consumptionData;
    }
    
    public float getThreshold()
    {
        return _threshold;
    }
    
    public PowerConsumptionData getLatestData()
    {
        return _consumptionData[_consumptionData.Count - 1];
    }
}
    

using HomeAutomation.Interface;
using HomeAutomation.Model;

namespace HomeAutomation.Components;

public class EnergyConsumptionManager : ISmartHomeComponent
{
    private List<PowerConsumptionData> _consumptionData;
    private float _threshold;
    
    public EnergyConsumptionManager(float threshold)
    {
        _consumptionData = new List<PowerConsumptionData>();
        _threshold = threshold;
    }
}
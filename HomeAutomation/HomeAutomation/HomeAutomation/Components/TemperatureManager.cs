using HomeAutomation.Enum;
using HomeAutomation.Interface;

namespace HomeAutomation.Components;

public class TemperatureManager : ISmartHomeComponent
{
    private TEMPSTATE _state;
    private int _temperature;
    
    public TemperatureManager()
    {
        _state = TEMPSTATE.IDLE;
        _temperature = 25;
    }
    
}
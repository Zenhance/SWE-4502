using HomeAutomation.Enum;
using HomeAutomation.Factory;
using HomeAutomation.Interface;
using HomeAutomation.Model;

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
    
    public void update(SENSOR sensor, Command command)
    {
        float value = command.getValue();
        if (sensor == SENSOR.TEMPERATURE)
        {
            _state = TemperatureFactory.GetState(value);
            _temperature = TemperatureFactory.GetTemperature(value);
        }
    }
    
    public TEMPSTATE GetCurrentState()
    {
        return _state;
    }
    
    public int GetCurrentTemperatureGoal()
    {
        return _temperature;
    }
    
}
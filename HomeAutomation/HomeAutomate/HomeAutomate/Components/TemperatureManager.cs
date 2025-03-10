using HomeAutomate.Enum;
using HomeAutomate.Factory;
using HomeAutomate.Interfaces;

namespace HomeAutomate.Components;

public class TemperatureManager : ISmartHomeComponent
{
    private TEMPSTATE _state;
    private int _temperature;
    
    public TemperatureManager()
    {
        _state = TEMPSTATE.IDLE;
        _temperature = 25;
    }

    public void update(SENSOR sensor, float value)
    {
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
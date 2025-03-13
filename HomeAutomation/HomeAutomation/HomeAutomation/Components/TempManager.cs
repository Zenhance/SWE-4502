using HomeAutomate.Enum;
using HomeAutomate.Factory;
using HomeAutomate.Interfaces;
using HomeAutomate.Models;

namespace HomeAutomate.Components;

public class TempManager : ISmartHomeComponent
{
    private TEMPSTATE _state;
    private int _temperature;
    
    public TempManager()
    {
        _state = TEMPSTATE.IDLE;
        _temperature = 25;
    }
    
    public void update(SENSOR sensor, Command command)
    {
        float value = command.getValue();
        if (sensor == SENSOR.TEMPERATURE)
        {
            _state = TempFactory.GetState(value);
            _temperature = TempFactory.GetTemperature(value);
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
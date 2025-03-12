using HomeAutomation.ENUM;
using HomeAutomation.Factory;
using HomeAutomation.Interface;
using HomeAutomation.Models;

namespace HomeAutomation.Components;

public class TemperatureManager: ISmartHomeComponent
{
    private TEMPSTATE state;
    private int temperature;
    
    public TemperatureManager()
    {
        state = TEMPSTATE.IDLE;
        temperature = 25;
    }
    
    public void update(SENSOR sensor, Command command)
    {
        float value = command.getValue();
        if (sensor == SENSOR.TEMPERATURE)
        {
            state = TemperatureFactory.GetState(value);
            temperature = TemperatureFactory.GetTemperature(value);
        }
    }
    
    public TEMPSTATE GetState()
    {
        return state;
    }
    
    public int GetTemperature()
    {
        return temperature;
    }
}
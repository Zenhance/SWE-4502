using HomeAutomate.Enum;
using HomeAutomate.Interfaces;
using HomeAutomate.Models;

namespace HomeAutomate.Core;

public class EnvironmentState
{
    private float _motionLevel;
    private float _amnbientLightLevel;
    private float _temperature;
    private float _energyConsumption;
    
    private List<ISmartHomeComponent> _components;
    
    public EnvironmentState()
    {
        _components = new List<ISmartHomeComponent>();
        _motionLevel = 0;
        _amnbientLightLevel = 0;
        _temperature = 0;
        _energyConsumption = 0;
    }
    
    public void addComponent(ISmartHomeComponent component)
    {
        _components.Add(component);
    }
    
    public void setMotionLevel(float level)
    {
        _motionLevel = level;
        foreach(ISmartHomeComponent component in _components)
        {
            component.update(SENSOR.MOTION, new Command(level));
        }
    }
    
    public void setAmbientLightLevel(float level)
    {
        _amnbientLightLevel = level;
        foreach(ISmartHomeComponent component in _components)
        {
            component.update(SENSOR.LIGHT, new Command(level));
        }
    }
    
    public void setTemperature(float temperature)
    {
        _temperature = temperature;
        foreach(ISmartHomeComponent component in _components)
        {
            component.update(SENSOR.TEMPERATURE, new Command(temperature));
        }
    }
    
    public void setEnergyConsumption(float consumption)
    {
        _energyConsumption = consumption;
        foreach(ISmartHomeComponent component in _components)
        {
            component.update(SENSOR.ENERGY, new Command(consumption));
        }
    }
}
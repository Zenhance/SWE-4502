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
    
    public void setMotionLevel(Command command)
    {
        _motionLevel = command.getValue();
        foreach(ISmartHomeComponent component in _components)
        {
            component.update(SENSOR.MOTION, command);
        }
    }
    
    public void setAmbientLightLevel(Command command)
    {
        _amnbientLightLevel = command.getValue();
        foreach(ISmartHomeComponent component in _components)
        {
            component.update(SENSOR.LIGHT, command);
        }
    }
    
    public void setTemperature(Command command)
    {
        _temperature = command.getValue();
        foreach(ISmartHomeComponent component in _components)
        {
            component.update(SENSOR.TEMPERATURE, command);
        }
    }
    
    public void setEnergyConsumption(Command command)
    {
        _energyConsumption = command.getValue();
        foreach(ISmartHomeComponent component in _components)
        {
            component.update(SENSOR.ENERGY, command);
        }
    }
}
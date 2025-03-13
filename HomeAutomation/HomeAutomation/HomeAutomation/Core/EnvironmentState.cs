using HomeAutomate.Enum;
using HomeAutomate.Interfaces;
using HomeAutomate.Models;

namespace HomeAutomate.Core;

public class EnvironmentState
{
    private float _motionLevel;
    private float _ambientLightLevel;
    private float _temperature;
    private float _energyConsumption;
    private string _lastVoiceCommand;
    
    private readonly List<ISmartHomeComponent> _components;
    
    public EnvironmentState()
    {
        _components = new List<ISmartHomeComponent>();
        _motionLevel = 0;
        _ambientLightLevel = 0;
        _temperature = 0;
        _energyConsumption = 0;
        _lastVoiceCommand = "";
    }
    
    public void AddComponent(ISmartHomeComponent component)
    {
        _components.Add(component);
    }
    
    public void SetMotionLevel(Command command)
    {
        _motionLevel = command.getValue();
        foreach(ISmartHomeComponent component in _components)
        {
            component.update(SENSOR.MOTION, command);
        }
    }
    
    public void SetAmbientLightLevel(Command command)
    {
        _ambientLightLevel = command.getValue();
        foreach(ISmartHomeComponent component in _components)
        {
            component.update(SENSOR.LIGHT, command);
        }
    }
    
    public void SetTemperature(Command command)
    {
        _temperature = command.getValue();
        foreach(ISmartHomeComponent component in _components)
        {
            component.update(SENSOR.TEMPERATURE, command);
        }
    }
    
    public void SetEnergyConsumption(Command command)
    {
        _energyConsumption = command.getValue();
        foreach(ISmartHomeComponent component in _components)
        {
            component.update(SENSOR.ENERGY, command);
        }
    }
    
    
    public void SetVoiceCommand(Command command)
    {
        _lastVoiceCommand = command.getCommand();
        foreach(ISmartHomeComponent component in _components)
        {
            component.update(SENSOR.SOUND, command);
        }
    }
    
    public float GetMotionLevel()
    {
        return _motionLevel;
    }
    
    public float GetAmbientLightLevel()
    {
        return _ambientLightLevel;
    }
    
    public float GetTemperature()
    {
        return _temperature;
    }
    
    public float GetEnergyConsumption()
    {
        return _energyConsumption;
    }
    
    public string GetLastVoiceCommand()
    {
        return _lastVoiceCommand;
    }
    
    public List<ISmartHomeComponent> GetComponents()
    {
        return _components;
    }
}
using HomeAutomation.ENUM;
using HomeAutomation.Interface;
using HomeAutomation.Models;

namespace HomeAutomation.Core;

public class EnvironmentState
{
    private float motionLevel;
    private float temperature;
    private float ambientLightLevel;
    private float energyConsumption;
    private string lastVoiceCommand;

    private readonly List<ISmartHomeComponent> components;
    
    public EnvironmentState()
    {
        components = new List<ISmartHomeComponent>();
        motionLevel = 0;
        temperature = 0;
        ambientLightLevel = 0;
        energyConsumption = 0;
        lastVoiceCommand = "";
    }
    
    public void AddComponent(ISmartHomeComponent component)
    {
        components.Add(component);
    }
    
    public void SetMotionLevel(Command command)
    {
        motionLevel = command.getValue();
        foreach (ISmartHomeComponent component in components)
        {
            component.update(SENSOR.MOTION, command);
        }
    }
    
    public void SetTemperature(Command command)
    {
        temperature = command.getValue();
        foreach (ISmartHomeComponent component in components)
        {
            component.update(SENSOR.TEMPERATURE, command);
        }
    }
    
    public void SetAmbientLightLevel(Command command)
    {
        ambientLightLevel = command.getValue();
        foreach (ISmartHomeComponent component in components)
        {
            component.update(SENSOR.LIGHT, command);
        }
    }
    
    public void SetEnergyConsumption(Command command)
    {
        energyConsumption = command.getValue();
        foreach (ISmartHomeComponent component in components)
        {
            component.update(SENSOR.ENERGY, command);
        }
    }
    
    public void SetVoiceCommand(Command command)
    {
        lastVoiceCommand = command.getCommand();
        foreach (ISmartHomeComponent component in components)
        {
            component.update(SENSOR.VOICE, command);
        }
    }
    
    public float GetMotionLevel()
    {
        return motionLevel;
    }
    
    public float GetTemperature()
    {
        return temperature;
    }
    
    public float GetAmbientLightLevel()
    {
        return ambientLightLevel;
    }
    
    public float GetEnergyConsumption()
    {
        return energyConsumption;
    }
    
    public string GetLastVoiceCommand()
    {
        return lastVoiceCommand;
    }

    public List<ISmartHomeComponent> GetComponents()
    {
        return components;
    }
    
    

}
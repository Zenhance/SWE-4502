using HomeAutomation.Core;
using HomeAutomation.ENUM;
using HomeAutomation.Interface;
using HomeAutomation.Models;

namespace HomeAutomation.Components;

public class RemoteAccessManager:ISmartHomeComponent
{
    private EnvironmentState environmentState;
    
    public RemoteAccessManager(EnvironmentState environmentState)
    {
        this.environmentState = environmentState;
    }
    
    public void update(SENSOR sensor, Command command)
    {
        
    }
    
    public float getTemperature()
    {
        return environmentState.GetTemperature();
    }
    
    public float getLightLevel()
    {
        return environmentState.GetAmbientLightLevel();
    }
    
    public float getMotionLevel()
    {
        return environmentState.GetMotionLevel();
    }
    
    public float getEnergyConsumption()
    {
        return environmentState.GetEnergyConsumption();
    }

    public void setVoiceCommand(Command command)
    {
        environmentState.SetVoiceCommand(command);
    }
    
    public void setTemperature(Command command)
    {
        environmentState.SetTemperature(command);
    }
    
    public void setAmbientLightLevel(Command command)
    {
        environmentState.SetAmbientLightLevel(command);
    }
    
    public void setMotionLevel(Command command)
    {
        environmentState.SetMotionLevel(command);
    }
    
    public void setEnergyConsumption(Command command)
    {
        environmentState.SetEnergyConsumption(command);
    }
    
}
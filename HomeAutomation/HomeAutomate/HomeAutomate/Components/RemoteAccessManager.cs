using HomeAutomate.Core;
using HomeAutomate.Enum;
using HomeAutomate.Interfaces;
using HomeAutomate.Models;

namespace HomeAutomate.Components;

public class RemoteAccessManager : ISmartHomeComponent
{
    private EnvironmentState _environmentState;
    
    public RemoteAccessManager(EnvironmentState environmentState)
    {
        _environmentState = environmentState;
    }
    
    public void update(SENSOR sensor, Command command)
    {
        
    }
    
    public float getTemperature()
    {
        return _environmentState.GetTemperature();
    }
    
    public float getMotionLevel()
    {
        return _environmentState.GetMotionLevel();
    }
    
    public float getAmbientLightLevel()
    {
        return _environmentState.GetAmbientLightLevel();
    }
    
    public float getEnergyConsumption()
    {
        return _environmentState.GetEnergyConsumption();
    }
    
    public void setVoiceCommand(Command command)
    {
        _environmentState.SetVoiceCommand(command);
    }
    
    public string getLastVoiceCommand()
    {
        return _environmentState.GetLastVoiceCommand();
    }
    
    public void setTemperature(Command command)
    {
        _environmentState.SetTemperature(command);
    }
    
    public void setMotionLevel(Command command)
    {
        _environmentState.SetMotionLevel(command);
    }
    
    public void setAmbientLightLevel(Command command)
    {
        _environmentState.SetAmbientLightLevel(command);
    }
    
    public void setEnergyConsumption(Command command)
    {
        _environmentState.SetEnergyConsumption(command);
    }
    
    
    
}
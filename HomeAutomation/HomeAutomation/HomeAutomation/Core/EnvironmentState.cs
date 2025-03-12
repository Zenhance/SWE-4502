using HomeAutomation.Interface;

namespace HomeAutomation.Core;

public class EnvironmentState
{
    private float _motionLevel;
    private float _temperature;
    private float _ambientLightLevel;
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
    
    
}
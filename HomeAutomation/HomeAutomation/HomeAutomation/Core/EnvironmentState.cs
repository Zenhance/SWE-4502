using HomeAutomation.Enum;
using HomeAutomation.Interface;
using HomeAutomation.Model;

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
    
    public void AddComponent(ISmartHomeComponent component)
    {
        _components.Add(component);
    }
    
    public void SetMotionLevel(Command command)
    {
        _motionLevel = command.GetValue();
        foreach(ISmartHomeComponent component in _components)
        {
            component.update(SENSOR.MOTION, command);
        }
    }
    
    
}
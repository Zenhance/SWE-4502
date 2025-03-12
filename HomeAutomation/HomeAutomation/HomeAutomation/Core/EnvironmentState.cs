using HomeAutomation.Interface;

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

}
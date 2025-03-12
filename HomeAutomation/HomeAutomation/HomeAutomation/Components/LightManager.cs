using HomeAutomation.ENUM;
using HomeAutomation.Interface;
using HomeAutomation.Models;

namespace HomeAutomation.Components;

public class LightManager:ISmartHomeComponent
{
    private LIGHTMODE currentMode;
    private float currentLightLevel;
    
    public LightManager()
    {
        currentMode = LIGHTMODE.DAYLIGHT;
        currentLightLevel = 1.0f;
    }
    
    public void update(SENSOR sensor, Command command)
    {
        
    }
}
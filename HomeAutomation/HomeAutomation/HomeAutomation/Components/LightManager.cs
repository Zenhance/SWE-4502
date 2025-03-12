using HomeAutomation.ENUM;
using HomeAutomation.Factory;
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
        float value = command.getValue();
        if (sensor == SENSOR.MOTION)
        {
            currentLightLevel = LightModeFactory.getLevel(value);
        }
        if (sensor == SENSOR.LIGHT)
        {
            currentMode = LightModeFactory.getMode(value);
        }
    }
    
    public LIGHTMODE GetCurrentMode()
    {
        return currentMode;
    }
    
    public float GetCurrentLightLevel()
    {
        return currentLightLevel;
    }
}
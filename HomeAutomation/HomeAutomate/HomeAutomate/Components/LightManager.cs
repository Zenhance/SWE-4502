using HomeAutomate.Enum;
using HomeAutomate.Factory;
using HomeAutomate.Interfaces;

namespace HomeAutomate.Components;

public class LightManager : ISmartHomeComponent
{
    private LIGHTMODE _currentMode;
    private float _currentLightLevel;
    
    public LightManager()
    {
        _currentMode = LIGHTMODE.DAYLIGHT;
        _currentLightLevel = 1.0f;
    }
    
    public void update(SENSOR sensor, float value)
    {
        if (sensor == SENSOR.LIGHT)
        {
            // Value = ambient light level
            _currentMode = LightModeFactory.getMode(value);
        }
        
        if (sensor == SENSOR.MOTION)
        {
            // Value = motion level
            _currentLightLevel = LightModeFactory.getLevel(value);
        }
        
    }
    
    public LIGHTMODE getCurrentMode()
    {
        return _currentMode;
    }
    
    public float getCurrentLightLevel()
    {
        return _currentLightLevel;
    }
}
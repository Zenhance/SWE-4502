using HomeAutomate.Core;
using HomeAutomate.Enum;
using HomeAutomate.Interfaces;
using HomeAutomate.Models;

namespace HomeAutomate.Components;

public class VoiceCommandManager : ISmartHomeComponent
{
    private EnvironmentState _environment;
    
    public VoiceCommandManager(EnvironmentState environment)
    {
        _environment = environment;
    }
    
    public void update(SENSOR sensor, Command command)
    {
        string commandString = command.getCommand();
        if (sensor == SENSOR.SOUND)
        {
            
        }
    }
}
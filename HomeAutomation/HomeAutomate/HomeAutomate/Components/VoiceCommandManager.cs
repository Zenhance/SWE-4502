using HomeAutomate.Core;
using HomeAutomate.Enum;
using HomeAutomate.Interfaces;
using HomeAutomate.Models;

namespace HomeAutomate.Components;

public class VoiceCommandManager : ISmartHomeComponent
{
    private EnvironmentState _environment;
    private List<COMMANDS> _commands;
    
    public VoiceCommandManager(EnvironmentState environment)
    {
        _environment = environment;
        _commands = new List<COMMANDS>();
    }
    
    public void update(SENSOR sensor, Command command)
    {
        string commandString = command.getCommand();
        if (sensor == SENSOR.SOUND)
        {
            
        }
    }
}
using HomeAutomate.Core;
using HomeAutomate.Enum;
using HomeAutomate.Interfaces;
using HomeAutomate.Models;
using HomeAutomation.Executor;

namespace HomeAutomate.Components;

public class VoiceCommandManager:ISmartHomeComponent
{
    private EnvironmentState _environment;
    
    public VoiceCommandManager(EnvironmentState environment)
    {
        _environment = environment;
    }
    
    public void update(SENSOR sensor, Command command)
    {
        if (sensor == SENSOR.SOUND)
        {
            StateChangeExecutor sce = ExecutorFactory.getExecutor(command, _environment);
            sce.execute();
        }
    }
    
    public EnvironmentState getEnvironment()
    {
        return _environment;
    }
}
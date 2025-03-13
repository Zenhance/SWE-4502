using HomeAutomation.Core;
using HomeAutomation.Enum;
using HomeAutomation.Executor;
using HomeAutomation.Factory;
using HomeAutomation.Interface;
using HomeAutomation.Model;

namespace HomeAutomation.Components;

public class VoiceCommandManager : ISmartHomeComponent
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
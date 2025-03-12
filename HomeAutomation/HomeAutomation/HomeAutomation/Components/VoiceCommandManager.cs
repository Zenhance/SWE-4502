using HomeAutomation.Core;
using HomeAutomation.ENUM;
using HomeAutomation.Executor;
using HomeAutomation.Factory;
using HomeAutomation.Interface;
using HomeAutomation.Models;

namespace HomeAutomation.Components;

public class VoiceCommandManager:ISmartHomeComponent
{
    private EnvironmentState environmentState;

    public VoiceCommandManager(EnvironmentState environmentState)
    {
        this.environmentState = environmentState;
    }
    
    public void update(SENSOR sensor, Command command)
    {
        if (sensor == SENSOR.VOICE)
        {
            StateChangeExecutor sce = ExecutorFactory.getExecutor(command, environmentState);
            sce.execute();
        }
    }

    public EnvironmentState getEnvironment()
    {
        return environmentState;
    }
    
}
using HomeAutomation.Core;
using HomeAutomation.ENUM;
using HomeAutomation.Interface;
using HomeAutomation.Models;

namespace HomeAutomation.Components;

public class RemoteAccessManager:ISmartHomeComponent
{
    private EnvironmentState environmentState;
    
    public RemoteAccessManager(EnvironmentState environmentState)
    {
        this.environmentState = environmentState;
    }
    
    public void update(SENSOR sensor, Command command)
    {
        
    }
}
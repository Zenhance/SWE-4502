using HomeAutomation.Core;
using HomeAutomation.Enum;
using HomeAutomation.Interface;
using HomeAutomation.Model;

namespace HomeAutomation.Components;

public class RemoteAccessManager : ISmartHomeComponent
{
    private EnvironmentState _environmentState;
    
    public RemoteAccessManager(EnvironmentState environmentState)
    {
        _environmentState = environmentState;
    }
    
    public void update(SENSOR sensor, Command command)
    {
        
    }
}
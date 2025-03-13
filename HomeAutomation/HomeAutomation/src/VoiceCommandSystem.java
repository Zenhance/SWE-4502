public class VoiceCommandSystem
{
    public void processVoiceCommand(String command, HomeAutomationSystem system)
    {
        if (command.equals("TURN_ON_LIGHT"))
        {
            SystemState newState = new SystemState();
            newState.lightLevel = 100;
            system.setSystemState(newState);
        }
        else if (command.equals("TURN_OFF_LIGHT"))
        {
            SystemState newState = new SystemState();
            newState.lightLevel = 0;
            system.setSystemState(newState);
        }
    }
}

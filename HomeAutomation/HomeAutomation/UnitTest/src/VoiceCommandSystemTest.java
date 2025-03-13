import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VoiceCommandSystemTest
{

    @Test
    public void testProcessVoiceCommandTurnOnLight()
    {
        HomeAutomationSystem homeSystem = new HomeAutomationSystem();
        VoiceCommandSystem voiceCommandSystem = new VoiceCommandSystem();

        voiceCommandSystem.processVoiceCommand("TURN_ON_LIGHT", homeSystem);

        assertEquals(100, homeSystem.getSystemState().lightLevel, "Light level should be 100 when turned on");
    }

    @Test
    public void testProcessVoiceCommandTurnOffLight()
    {
        HomeAutomationSystem homeSystem = new HomeAutomationSystem();
        VoiceCommandSystem voiceCommandSystem = new VoiceCommandSystem();

        voiceCommandSystem.processVoiceCommand("TURN_OFF_LIGHT", homeSystem);

        assertEquals(0, homeSystem.getSystemState().lightLevel, "Light level should be 0 when turned off");
    }

    @Test
    public void testInvalidVoiceCommand()
    {
        HomeAutomationSystem homeSystem = new HomeAutomationSystem();
        VoiceCommandSystem voiceCommandSystem = new VoiceCommandSystem();

        voiceCommandSystem.processVoiceCommand("INVALID_COMMAND", homeSystem);

        assertEquals(0, homeSystem.getSystemState().lightLevel, "Light level should not change for an invalid command");
    }

    @Test
    public void testEmptyVoiceCommand()
    {
        HomeAutomationSystem homeSystem = new HomeAutomationSystem();
        VoiceCommandSystem voiceCommandSystem = new VoiceCommandSystem();

        voiceCommandSystem.processVoiceCommand("", homeSystem);

        assertEquals(0, homeSystem.getSystemState().lightLevel, "Light level should not change for an empty command");
    }
}

package components;
import core.Sensor;

public class VoiceCommandProcessor implements Sensor
{
    @Override
    public void onStateChange(String newState) {
        System.out.println("Processing voice command: " + newState);
    }

    //Processes natural language commands
    public void processCommand(String command)
    {
        if(command.contains("turn on"))
        {
            System.out.println("Turning on device");
        }
        else if(command.contains("turn off"))
        {
            System.out.println("Turning off device");
        }
        else
        {
            System.out.println("Command not recognized");
        }
    }
    //Translates commands into system state changes
    public void translateCommand(String command)
    {
        if(command.contains("turn on"))
        {
            onStateChange("on");
        }
        else if(command.contains("turn off"))
        {
            onStateChange("off");
        }
    }

}

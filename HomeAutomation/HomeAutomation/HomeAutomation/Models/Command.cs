namespace HomeAutomation.Models;

public class Command
{
    private string command;
    private float value;

    public Command(string command, float value)
    {
        this.command = command;
        this.value = value;
    }

    public Command(string command)
    {
        this.command = command;
        this.value = 0;
    }

    public Command(float value)
    {
        this.command = "";
        this.value = value;
    }
    
    public string getCommand()
    {
        return command;
    }
    
    public float getValue()
    {
        return value;
    }
    
}
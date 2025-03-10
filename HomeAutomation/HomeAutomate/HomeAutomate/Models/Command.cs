namespace HomeAutomate.Models;

public class Command
{
    private string _command;
    private float _value;
    
    public Command(string command, float value)
    {
        _command = command;
        _value = value;
    }
    
    public Command(string command)
    {
        _command = command;
        _value = 0;
    }
    
    public Command(float value)
    {
        _command = "";
        _value = value;
    }
    
    public string getCommand()
    {
        return _command;
    }
    
    public float getValue()
    {
        return _value;
    }
}
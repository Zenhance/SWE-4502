namespace LabFinal;

public class CommandLog
{
    public CommandType Type { get; set;}
    public string Description { get; set; }
    public DateTime Timestamp { get; set; }   
    
    public CommandLog(CommandType type, string description)
    {
        Type = type;
        Description = description;
        Timestamp = DateTime.Now;
    }
    
}
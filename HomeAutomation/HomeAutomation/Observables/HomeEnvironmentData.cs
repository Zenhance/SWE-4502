namespace HomeAutomation.Observables;

public class HomeEnvironmentData
{
    public bool MotionDetected { get; set; }
    public string MotionLocation { get; set; }
    public DateTime LastMotionTime { get; set; }
    
    public int AmbientLightLevel { get; set; }
    public bool RoomOccupied { get; set; }
    
    public double Temperature { get; set; }
    public double TargetTemperature { get; set; }
    
    public double CurrentEnergyUsage { get; set; } 
    
    public string LastVoiceCommand { get; set; }
    public bool VoiceCommandProcessed { get; set; }
    
    public DateTime Timestamp { get; set; }
    
    public HomeEnvironmentData()
    {
        Timestamp = DateTime.Now;
    }
    
    public HomeEnvironmentData Clone()
    {
        return new HomeEnvironmentData
        {
            MotionDetected = MotionDetected,
            MotionLocation = MotionLocation,
            LastMotionTime = LastMotionTime,
            AmbientLightLevel = AmbientLightLevel,
            RoomOccupied = RoomOccupied,
            Temperature = Temperature,
            TargetTemperature = TargetTemperature,
            CurrentEnergyUsage = CurrentEnergyUsage,
            LastVoiceCommand = LastVoiceCommand,
            VoiceCommandProcessed = VoiceCommandProcessed,
            Timestamp = Timestamp
        };
    }
}
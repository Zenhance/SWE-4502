using HomeAutomation.Observables;

namespace HomeAutomation.Observers;

public class VoiceControl : IObserver
{
    private string _lastCommand;
    private readonly List<string> _commandHistory = new List<string>();
    
    public void Update(HomeEnvironmentData data)
    {
        if (!string.IsNullOrEmpty(data.LastVoiceCommand) && data.VoiceCommandProcessed)
        {
            _lastCommand = data.LastVoiceCommand;
            _commandHistory.Add(_lastCommand);
        }
    }
    
    public string GetLastCommand() => _lastCommand;
    
    public List<string> GetCommandHistory() => new List<string>(_commandHistory);
    
    public bool ProcessCommand(string command, HomeEnvironment environment)
    {
        if (command.Contains("lights", StringComparison.OrdinalIgnoreCase))
        {
            if (command.Contains("on", StringComparison.OrdinalIgnoreCase))
            {
                environment.SetAmbientLightLevel(50);
                environment.SetRoomOccupancy(true);
                return true;
            }
            else if (command.Contains("off", StringComparison.OrdinalIgnoreCase))
            {
                environment.SetAmbientLightLevel(100);
                environment.SetRoomOccupancy(false);
                return true;
            }
        }
        else if (command.Contains("temperature", StringComparison.OrdinalIgnoreCase))
        {
            string[] words = command.Split(' ');
            foreach (var word in words)
            {
                if (double.TryParse(word, out double temp))
                {
                    environment.SetTargetTemperature(temp);
                    return true;
                }
            }
        }
        
        return false;
    }
}
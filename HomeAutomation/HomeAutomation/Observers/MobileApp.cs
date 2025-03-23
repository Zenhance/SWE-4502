using HomeAutomation.Observables;

namespace HomeAutomation.Observers;

public class MobileApp : IObserver
{
    private HomeEnvironmentData _currentData;
    private readonly List<string> _notifications = new List<string>();
    
    public void Update(HomeEnvironmentData data)
    {
        _currentData = data;
        
        if (data.MotionDetected)
        {
            AddNotification($"Motion detected in {data.MotionLocation}");
        }
        
    }
    
    private void AddNotification(string message)
    {
        _notifications.Add($"[{DateTime.Now}] {message}");
        
        if (_notifications.Count > 100)
        {
            _notifications.RemoveAt(0);
        }
    }
    
    public HomeEnvironmentData GetCurrentData() => _currentData;
    
    public List<string> GetNotifications() => new List<string>(_notifications);
    
    public bool SendCommand(string command, HomeEnvironment environment)
    {
        environment.ProcessVoiceCommand(command);
        return true;
    }
}
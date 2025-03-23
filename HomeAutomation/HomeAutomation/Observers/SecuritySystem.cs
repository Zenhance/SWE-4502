using HomeAutomation.Observables;

namespace HomeAutomation.Observers;

public class SecuritySystem : IObserver
{
    private bool _motionDetected;
    private string _motionLocation;
    private DateTime _lastMotionTime;
    private readonly List<string> _activityLog = [];
    
    public void Update(HomeEnvironmentData data)
    {
        if (_motionDetected != data.MotionDetected || _motionLocation != data.MotionLocation)
        {
            _motionDetected = data.MotionDetected;
            _motionLocation = data.MotionLocation;
            _lastMotionTime = data.LastMotionTime;
            
            if (_motionDetected)
            {
                LogActivity($"Motion detected in {_motionLocation} at {_lastMotionTime}");
                AnalyzeActivityPattern();
            }
        }
    }
    
    private void LogActivity(string activity)
    {
        _activityLog.Add(activity);
        
        if (_activityLog.Count > 1000)
        {
            _activityLog.RemoveAt(0);
        }
    }
    
    public bool IsMotionDetected() => _motionDetected;
    
    public string GetMotionLocation() => _motionLocation;
    
    public DateTime GetLastMotionTime() => _lastMotionTime;
    
    public List<string> GetActivityLog() => new List<string>(_activityLog);
    
    public bool IsSuspiciousActivity()
    {
        
        return false;
    }
    
    private void AnalyzeActivityPattern()
    { 
        //TODO: Implementation would analyze patterns
    }
}
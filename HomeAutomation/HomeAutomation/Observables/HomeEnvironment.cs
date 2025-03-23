using HomeAutomation.Observers;

namespace HomeAutomation.Observables;

public class HomeEnvironment : ISubject
{
    private readonly List<IObserver> _observers;
    private HomeEnvironmentData _environmentData;
    
    public HomeEnvironment()
    {
        _observers = new List<IObserver>();
        _environmentData = new HomeEnvironmentData();
    }
    
    public void RegisterObserver(IObserver observer)
    {
        if (!_observers.Contains(observer))
        {
            _observers.Add(observer);
        }
    }
    
    public void RemoveObserver(IObserver observer)
    {
        _observers.Remove(observer);
    }
    
    public void NotifyObservers()
    {
        foreach (var observer in _observers)
        {
            observer.Update(_environmentData.Clone());
        }
    }
    
    public void SetMotionDetected(bool detected, string location)
    {
        _environmentData.MotionDetected = detected;
        _environmentData.MotionLocation = location;
        _environmentData.LastMotionTime = DateTime.Now;
        _environmentData.Timestamp = DateTime.Now;
        NotifyObservers();
    }
    
    public void SetAmbientLightLevel(int level)
    {
        _environmentData.AmbientLightLevel = Math.Clamp(level, 0, 100);
        _environmentData.Timestamp = DateTime.Now;
        NotifyObservers();
    }
    
    public void SetRoomOccupancy(bool occupied)
    {
        _environmentData.RoomOccupied = occupied;
        _environmentData.Timestamp = DateTime.Now;
        NotifyObservers();
    }
    
    public void SetTemperature(double temperature)
    {
        _environmentData.Temperature = temperature;
        _environmentData.Timestamp = DateTime.Now;
        NotifyObservers();
    }
    
    public void SetTargetTemperature(double targetTemperature)
    {
        _environmentData.TargetTemperature = targetTemperature;
        _environmentData.Timestamp = DateTime.Now;
        NotifyObservers();
    }
    
    public void SetCurrentEnergyUsage(double watts)
    {
        _environmentData.CurrentEnergyUsage = watts;
        _environmentData.Timestamp = DateTime.Now;
        NotifyObservers();
    }
    
    public void ProcessVoiceCommand(string command)
    {
        _environmentData.LastVoiceCommand = command;
        _environmentData.VoiceCommandProcessed = true;
        _environmentData.Timestamp = DateTime.Now;
        NotifyObservers();
    }
    public HomeEnvironmentData GetCurrentData()
    {
        return _environmentData.Clone();
    }
}
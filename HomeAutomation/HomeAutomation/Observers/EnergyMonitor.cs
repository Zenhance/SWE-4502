using HomeAutomation.Observables;

namespace HomeAutomation.Observers;

public class EnergyMonitor : IObserver
{
    private double _currentUsage;
    private readonly List<double> _usageHistory = new List<double>();
    private readonly List<DateTime> _timeHistory = new List<DateTime>();
    
    public void Update(HomeEnvironmentData data)
    {
        _currentUsage = data.CurrentEnergyUsage;
        _usageHistory.Add(_currentUsage);
        _timeHistory.Add(data.Timestamp);
        
        if (_usageHistory.Count > 1440) 
        {
            _usageHistory.RemoveAt(0);
            _timeHistory.RemoveAt(0);
        }
        
        AnalyzeEnergyUsage();
    }
    
    private void AnalyzeEnergyUsage()
    {
        
        //TODO:: This is a placeholder for the actual implementation
    }
    
    public double GetCurrentUsage() => _currentUsage;
    
    public double GetDailyUsage()
    {
        
        double totalWattHours = 0;
        
        if (_usageHistory.Count < 2) return 0;
        
        for (int i = 1; i < _usageHistory.Count; i++)
        {
            double avgWatts = (_usageHistory[i] + _usageHistory[i-1]) / 2;
            double hours = (_timeHistory[i] - _timeHistory[i-1]).TotalHours;
            totalWattHours += avgWatts * hours;
        }
        
        return totalWattHours / 1000; 
    }
    
    public bool IsUnusualConsumption()
    {
        return false;
    }
}
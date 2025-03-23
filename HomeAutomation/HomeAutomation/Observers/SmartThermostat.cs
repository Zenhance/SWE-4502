using HomeAutomation.Observables;

namespace HomeAutomation.Observers;

public class SmartThermostat : IObserver
{
    private double _currentTemperature;
    private double _targetTemperature;
    private bool _heatingOn = false;
    private bool _coolingOn = false;
    
    public void Update(HomeEnvironmentData data)
    {
        _currentTemperature = data.Temperature;
        _targetTemperature = data.TargetTemperature;
        
        AdjustHVAC();
    }
    
    private void AdjustHVAC()
    {
        const double threshold = 1.0; 
        
        if (_currentTemperature < _targetTemperature - threshold)
        {
            _heatingOn = true;
            _coolingOn = false;
        }
        else if (_currentTemperature > _targetTemperature + threshold)
        {
            _heatingOn = false;
            _coolingOn = true;
        }
        else if (Math.Abs(_currentTemperature - _targetTemperature) < 0.5)
        {
            _heatingOn = false;
            _coolingOn = false;
        }
    }
    
    public bool IsHeatingOn() => _heatingOn;
    
    public bool IsCoolingOn() => _coolingOn;
    
    public double GetCurrentTemperature() => _currentTemperature;
    
    public double GetTargetTemperature() => _targetTemperature;
}
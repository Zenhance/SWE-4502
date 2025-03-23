using HomeAutomation.Observables;

namespace HomeAutomation.Observers;

public class SmartLighting : IObserver
{
    private int _ambientLightLevel;
    private bool _roomOccupied;
    private int _currentBrightness = 0;
    
    public void Update(HomeEnvironmentData data)
    {
        _ambientLightLevel = data.AmbientLightLevel;
        _roomOccupied = data.RoomOccupied;
        
        AdjustLighting();
    }
    
    private void AdjustLighting()
    {
        if (!_roomOccupied)
        {
            _currentBrightness = 0;
            return;
        }
        
        
        _currentBrightness = Math.Max(0, 100 - _ambientLightLevel);
        
        //TODO: Additional logic for time of day would go here
    }
    
    public int GetCurrentBrightness() => _currentBrightness;
    
    public void SetScene(string sceneName)
    {
        switch (sceneName.ToLower())
        {
            case "reading":
                _currentBrightness = 80;
                break;
            case "movie":
                _currentBrightness = 20;
                break;
            case "evening":
                _currentBrightness = 40;
                break;
            default:
                _currentBrightness = 60;
                break;
        }
    }
}
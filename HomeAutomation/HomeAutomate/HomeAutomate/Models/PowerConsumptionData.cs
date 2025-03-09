namespace HomeAutomate.Models;

public class PowerConsumptionData
{
    private float _consumption;
    private DateTime _timestamp;
    
    public PowerConsumptionData(float consumption)
    {
        _consumption = consumption;
        _timestamp = DateTime.Now;
    }
    
    public float getConsumption()
    {
        return _consumption;
    }
    
    public DateTime getTimestamp()
    {
        return _timestamp;
    }
}
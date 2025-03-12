namespace HomeAutomation.Model;

public class PowerConsumptionData
{
    private float _consumption;
    private DateTime _timestamp;
    
    public PowerConsumptionData(float consumption)
    {
        _consumption = consumption;
        _timestamp = DateTime.Now;
    }
}
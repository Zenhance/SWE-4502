namespace HomeAutomation.Models;

public class PowerConsumptionData
{
    private float consumption;
    private DateTime time;
    
    public PowerConsumptionData(float consumption)
    {
        this.consumption = consumption;
        this.time = DateTime.Now;
    }
    
    public float getConsumption()
    {
        return consumption;
    }
    
    public DateTime getTimestamp()
    {
        return time;
    }
}
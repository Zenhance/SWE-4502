using HomeAutomation.ENUM;

namespace HomeAutomation.Models;

public class MotionData
{
    private float value;
    private DateTime time;
    private MOTIONBEHAVIOR behavior;
    
    public MotionData(float value, DateTime time, MOTIONBEHAVIOR behavior)
    {
        this.value = value;
        this.time = time;
        this.behavior = behavior;
    }
}
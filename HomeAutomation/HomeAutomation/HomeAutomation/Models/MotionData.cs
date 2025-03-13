using HomeAutomate.Enum;

namespace HomeAutomate.Models;

public class MotionData
{
    private float _value;
    private DateTime _time;
    private MOTIONBEHAVIOR _motionbehavior;
    
    public MotionData(float value, MOTIONBEHAVIOR motionbehavior)
    {
        _value = value;
        _time = DateTime.Now;
        _motionbehavior = motionbehavior;
    }
    
    public float getValue()
    {
        return _value;
    }
    
    public DateTime getTime()
    {
        return _time;
    }
    
    public MOTIONBEHAVIOR getMotionBehavior()
    {
        return _motionbehavior;
    }
}
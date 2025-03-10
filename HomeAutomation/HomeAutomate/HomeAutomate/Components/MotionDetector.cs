using HomeAutomate.Enum;
using HomeAutomate.Interfaces;
using HomeAutomate.Models;

namespace HomeAutomate.Components;

public class MotionDetector : ISmartHomeComponent
{
    private List<MotionData> _motionData;
    private float _threshold;
    
    public MotionDetector(float threshold)
    {
        _threshold = threshold;
        _motionData = new List<MotionData>();
    }
    
    public void update(SENSOR sensor, Command command)
    {
        float value = command.getValue();
        if (sensor == SENSOR.MOTION)
        {
            if(value > _threshold)
            {
                _motionData.Add(new MotionData(value, MOTIONBEHAVIOR.SUSPICIOUSBEHAVIOR));
            }
            else
            {
                _motionData.Add(new MotionData(value, MOTIONBEHAVIOR.NORMALBEHAVIOR));
            }
        }
    }
    
    public List<MotionData> getMotionData()
    {
        return _motionData;
    }
    
    public MotionData getLatestMotionData()
    {
        return _motionData.Last();
    }
    
    public void clearMotionData()
    {
        _motionData.Clear();
    }
    
    public void setThreshold(float threshold)
    {
        _threshold = threshold;
    }
    
    public MotionData motionDataAt(int index)
    {
        return _motionData[index];
    }
    
    public int suspiciousCount()
    {
        return _motionData.Count(motionData => motionData.getMotionBehavior() == MOTIONBEHAVIOR.SUSPICIOUSBEHAVIOR);
    }
    
    public int normalCount()
    {
        return _motionData.Count(motionData => motionData.getMotionBehavior() == MOTIONBEHAVIOR.NORMALBEHAVIOR);
    }

    public MOTIONBEHAVIOR overall()
    {
        int suspiciousCount = this.suspiciousCount();
        int normalCount = this.normalCount();
        
        if(suspiciousCount > normalCount)
        {
            return MOTIONBEHAVIOR.SUSPICIOUSBEHAVIOR;
        }
        else
        {
            return MOTIONBEHAVIOR.NORMALBEHAVIOR;
        }
    }
}
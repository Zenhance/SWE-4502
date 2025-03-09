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
    
    public void update(SENSOR sensor, float value)
    {
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
}
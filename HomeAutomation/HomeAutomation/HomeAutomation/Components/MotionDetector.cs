using HomeAutomation.Enum;
using HomeAutomation.Interface;
using HomeAutomation.Model;

namespace HomeAutomation.Components;

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
}
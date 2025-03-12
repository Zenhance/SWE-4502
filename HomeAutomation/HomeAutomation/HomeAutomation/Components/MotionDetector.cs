using HomeAutomation.ENUM;
using HomeAutomation.Interface;
using HomeAutomation.Models;

namespace HomeAutomation.Components;

public class MotionDetector: ISmartHomeComponent
{
    private List<MotionData> motionDataList;
    private float threshold;
    
    public MotionDetector(float threshold)
    {
        motionDataList = new List<MotionData>();
        this.threshold = threshold;
    }
    
    public void update(SENSOR sensor, Command command)
    {
        float value = command.getValue();
        if (sensor == SENSOR.MOTION)
        {
            if (value > threshold)
            {
                motionDataList.Add(new MotionData(value, DateTime.Now, MOTIONBEHAVIOR.SUSPICIOUS));
            }
            else
            {
                motionDataList.Add(new MotionData(value, DateTime.Now, MOTIONBEHAVIOR.NORMAL));
            }
        }
    }
    
    public List<MotionData> GetMotionDataList()
    {
        return motionDataList;
    }
    
    public MotionData GetLatestMotionData()
    {
        return motionDataList.Last();
    }
    
    
    
    
}
using HomeAutomation.ENUM;
using HomeAutomation.Interface;
using HomeAutomation.Models;

namespace HomeAutomation.Components;

public class MotionDetector: ISmartHomeComponent
{
    private List<MotionData> motionData;
    private float threshold;
    
    public MotionDetector(float threshold)
    {
        motionData = new List<MotionData>();
        this.threshold = threshold;
    }
    
    public void update(SENSOR sensor, Command command)
    {
        float value = command.getValue();
        if (sensor == SENSOR.MOTION)
        {
            if (value > threshold)
            {
                motionData.Add(new MotionData(value, DateTime.Now, MOTIONBEHAVIOR.SUSPICIOUS));
            }
            else
            {
                motionData.Add(new MotionData(value, DateTime.Now, MOTIONBEHAVIOR.NORMAL));
            }
        }
    }
    
    public List<MotionData> GetMotionData()
    {
        return motionData;
    }
    
    public MotionData GetLatestMotionData()
    {
        return motionData.Last();
    }
    
    public void ClearMotionData()
    {
        motionData.Clear();
    }
    
    public float GetThreshold()
    {
        return threshold;
    }
    
    public void SetThreshold(float threshold)
    {
        this.threshold = threshold;
    }

    public MotionData motionDataAt(int index)
    {
        return motionData[index];
    }
    
    public int suspiciousMotionCount()
    {
        return motionData.Count(motionData => motionData.getBehavior() == MOTIONBEHAVIOR.SUSPICIOUS);
    }
    
    public int normalMotionCount()
    {
        return motionData.Count(motionData => motionData.getBehavior() == MOTIONBEHAVIOR.NORMAL);
    }

    public MOTIONBEHAVIOR overall()
    {
        int susCount = this.suspiciousMotionCount();
        int normCount = this.normalMotionCount();
        
        if (susCount > normCount)
        {
            return MOTIONBEHAVIOR.SUSPICIOUS;
        }
        else
        {
            return MOTIONBEHAVIOR.NORMAL;
        }
    }
    
    
}
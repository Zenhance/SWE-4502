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
}
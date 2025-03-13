namespace HomeAutomation.Motion.Tests;

public class MotionDetectorTests
{
    [Fact()]
    public void UpdateTest()
    {
        MotionDetector motionDetector = new MotionDetector();
        MotionState state = new MotionState();
        var result = motionDetector.Update(state);
        Assert.Equal(state.ToString(), result);
    }
}
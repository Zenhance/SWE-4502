using HomeAutomate.Core;
using HomeAutomate.Models;
using HomeAutomate.Components;
using HomeAutomate.Executor;
using HomeAutomate.Enum;

namespace HomeAutomationTest;

public class MotionTest
{
    [SetUp]
    public void Setup()
    {
    }

    [Test]
    public void setMotionLevelTest()
    {
        MotionDetector motionDetector = new MotionDetector(0.5f);
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.addComponent(motionDetector);
        environmentState.setMotionLevel(new Command(0.6f));
        MOTIONBEHAVIOR motionBehavior = motionDetector.overall();
        Assert.AreEqual(motionBehavior, MOTIONBEHAVIOR.SUSPICIOUSBEHAVIOR);
    }
}
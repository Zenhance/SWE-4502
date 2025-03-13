using HomeAutomation.Components;
using HomeAutomation.Core;
using HomeAutomation.ENUM;
using HomeAutomation.Models;

namespace HomeAutomationTest;

public class MotionTest
{
    [SetUp]
    public void Setup()
    {
    }

    [Test]
    public void TestSetMotionLevelSuspicious()
    {
        MotionDetector motionDetector = new MotionDetector(0.5f);
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.AddComponent(motionDetector);
        environmentState.SetMotionLevel(new Command(0.6f));
        MOTIONBEHAVIOR motionBehavior = motionDetector.overall();
        Assert.That(motionBehavior, Is.EqualTo(MOTIONBEHAVIOR.SUSPICIOUS));
    }
    
    [Test]
    public void TestSetMotionLevelNormal()
    {
        MotionDetector motionDetector = new MotionDetector(0.5f);
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.AddComponent(motionDetector);
        environmentState.SetMotionLevel(new Command(0.4f));
        MOTIONBEHAVIOR motionBehavior = motionDetector.overall();
        Assert.That(motionBehavior, Is.EqualTo(MOTIONBEHAVIOR.NORMAL));
    }

    [Test]
    public void TestSetMotionLevelMultipleSuspicious()
    {
        MotionDetector motionDetector = new MotionDetector(0.5f);
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.AddComponent(motionDetector);
        environmentState.SetMotionLevel(new Command(0.6f));
        environmentState.SetMotionLevel(new Command(0.6f));
        environmentState.SetMotionLevel(new Command(0.4f));
        MOTIONBEHAVIOR motionBehavior = motionDetector.overall();
        Assert.That(motionBehavior, Is.EqualTo(MOTIONBEHAVIOR.SUSPICIOUS));
    }
}
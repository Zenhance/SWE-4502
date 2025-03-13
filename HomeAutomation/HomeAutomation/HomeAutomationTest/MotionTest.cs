using HomeAutomation.Components;
using HomeAutomation.Core;
using HomeAutomation.Enum;
using HomeAutomation.Model;

namespace HomeAutomationTest;

public class MotionTest
{
    [SetUp]
    public void Setup()
    {
    }
    
    [Test]
    public void SetMotionLevelSuspiciousTest()
    {
        MotionDetector motionDetector = new MotionDetector(0.5f);
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.AddComponent(motionDetector);
        environmentState.SetMotionLevel(new Command(0.6f));
        MOTIONBEHAVIOR motionBehavior = motionDetector.overall();
        Assert.That(motionBehavior, Is.EqualTo(MOTIONBEHAVIOR.SUSPICIOUSBEHAVIOR));
    }
    
    [Test]
    public void SetMotionLevelNormalTest()
    {
        MotionDetector motionDetector = new MotionDetector(0.5f);
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.AddComponent(motionDetector);
        environmentState.SetMotionLevel(new Command(0.4f));
        MOTIONBEHAVIOR motionBehavior = motionDetector.overall();
        Assert.That(motionBehavior, Is.EqualTo(MOTIONBEHAVIOR.NORMALBEHAVIOR));
    }
    
    [Test]
    public void SetMotionLevelMultipleSuspiciousTest()
    {
        MotionDetector motionDetector = new MotionDetector(0.5f);
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.AddComponent(motionDetector);
        environmentState.SetMotionLevel(new Command(0.6f));
        environmentState.SetMotionLevel(new Command(0.6f));
        environmentState.SetMotionLevel(new Command(0.4f));
        MOTIONBEHAVIOR motionBehavior = motionDetector.overall();
        Assert.That(motionBehavior, Is.EqualTo(MOTIONBEHAVIOR.SUSPICIOUSBEHAVIOR));
    }
    
    
}